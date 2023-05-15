package com.example.QuizApplication;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository
public class QuizRepository {

    Map< Integer, Quiz> quizMap = new HashMap<>();

    public void addQuiz(Quiz quiz) {
        quizMap.put(quiz.getId(), quiz);
    }

    public Optional<Quiz> getQuizById(int id) {
        if( quizMap.containsKey(id) ){
            return Optional.of(quizMap.get(id));
        }
        return Optional.empty();
    }

    public List<Quiz> getAllQuizzes() {
        return quizMap.values().stream().toList();
    }
}
