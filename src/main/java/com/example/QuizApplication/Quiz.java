package com.example.QuizApplication;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class Quiz {

    private int id;
    private String question;
    private String[] options;
    private int rightAnswer;
    private Date startDate;
    private Date endDate;

    public Quiz() {
    }

    public Quiz(int id, String question, String[] options, int rightAnswer, Date startDate, Date endDate) {

        this.id = id;
        this.question = question;
        this.options = options;
        this.rightAnswer = rightAnswer;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    //Getters:

    public int getId() {
        return id;
    }

    public String getQuestion() {
        return question;
    }

    public String[] getOptions() {
        return options;
    }

    public int getRightAnswer() {
        return rightAnswer;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    //Setters:

    public void setId(int id) {
        this.id = id;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public void setOptions(String[] options) {
        this.options = options;
    }

    public void setRightAnswer(int rightAnswer) {
        this.rightAnswer = rightAnswer;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
}
