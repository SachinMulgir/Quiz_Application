package com.example.QuizApplication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class QuizService {

    @Autowired
    QuizRepository quizRepository;

    public void addQuiz(Quiz quiz) throws RuntimeException {
        Optional<Quiz> opt = this.quizRepository.getQuizById(quiz.getId());
        if( opt.isPresent() ){
            throw new RuntimeException("Quiz with id = " + quiz.getId() + " already exist");
        }
        this.quizRepository.addQuiz(quiz);
    }

    public List<Quiz> getActiveQuiz() {
        List<Quiz> quizzes = this.quizRepository.getAllQuizzes();
        Date currTime = new Date();
        List<Quiz> activeQuiz = new ArrayList<>();
        for( Quiz q : quizzes ){
            Date startDate = q.getStartDate();
            Date endDate = q.getEndDate();

            if( currTime.before(endDate) && currTime.after(startDate) ){
                activeQuiz.add(q);
            }
        }
        return activeQuiz;
    }

    public int getResult(int id) throws LessThanFiveMin, RuntimeException{
        Date currTime = new Date();
        System.out.println("Curr date : "+currTime);
        Optional<Quiz> opt = this.quizRepository.getQuizById(id);

        if( opt.isPresent() ){

            Quiz quiz = opt.get();
            Date endDate = quiz.getEndDate();

            long timeInMillis = endDate.getTime();

            Date after5Mins = new Date(timeInMillis + (5 * 60000));

            if( currTime.after(after5Mins)){
                return quiz.getRightAnswer();
            }
            else{
                throw new LessThanFiveMin("5 Minutes Not Reached");
            }

        }else{
            throw new RuntimeException("Quiz with id = " + id + " does not exist");
        }
    }

    public List<Quiz> getAllQuizzes() {
        return this.quizRepository.getAllQuizzes();
    }

    public String getStatus(int id) {
        Optional<Quiz> opt = this.quizRepository.getQuizById(id);

        if( opt.isEmpty() )throw new RuntimeException("Quiz with id = " + id + "does not exist.");

        Quiz quiz = opt.get();
        Date startDate = quiz.getStartDate();
        Date endDate = quiz.getEndDate();

        Date currTime = new Date();

        if(currTime.before(startDate) )return "inactive";
        else if( currTime.after(endDate) )return "finished";
        else return "active";
    }
}
