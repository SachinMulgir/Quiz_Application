package com.example.QuizApplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class QuizApplication {

	public static void main(String[] args) {
		SpringApplication.run(QuizApplication.class, args);
	}

    public static class LessThanFiveMIn extends RuntimeException{
        LessThanFiveMIn(String msg){
            super(msg);
        }
    }
}
