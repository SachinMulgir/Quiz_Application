package com.example.QuizApplication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.image.ReplicateScaleFilter;
import java.util.List;

@RestController
@RequestMapping("/quiz")
public class QuizController {

    @Autowired
    QuizService quizService;

    //POST Mapping:
    @PostMapping("/quizzes")
    public ResponseEntity addQuiz(@RequestBody Quiz quiz){
        try{
            this.quizService.addQuiz(quiz);
            return new ResponseEntity("Quiz Added Successfully!!", HttpStatus.CREATED);
        }
        catch (RuntimeException ex){
            return new ResponseEntity("Quiz with ID = "+ quiz.getId() + " already exist", HttpStatus.BAD_REQUEST);
        }
    }


    //GET Mapping:
    @GetMapping("/quizzes/active")
    public List<Quiz> getActiveQuiz() {
        return this.quizService.getActiveQuiz();
    }

    @GetMapping("/quizzes/{id}/result")
    public ResponseEntity getResult(@PathVariable int id){
        try{
            int ans = this.quizService.getResult(id);
            return new ResponseEntity(ans, HttpStatus.OK);
        }catch (RuntimeException ex){
            return new ResponseEntity("Quiz with id = " + id + " does not exist", HttpStatus.BAD_REQUEST);
        }catch (LessThanFiveMin ex){
            return new ResponseEntity("5 Min not passed", HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/quizzes/all")
    public List<Quiz> getAllQuizzes(){
        return this.quizService.getAllQuizzes();
    }

}
