package com.example.demo18;

import jakarta.persistence.*;

@Entity
public class Answer {
    @Id
    @Column(name = "answer_id")
    private int answerId;
    private String answer;

    @OneToOne(mappedBy = "answer") //However if v add mapped by then it will not have the FK questionid in answer table
    private Question question; //Making it multidirectional

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

//    public Answer(int answerId, String answer) {
//        this.answerId = answerId;
//        this.answer = answer;
//    }


    public Answer(int answerId, String answer, Question question) {
        this.answerId = answerId;
        this.answer = answer;
        this.question = question;
    }

    public Answer() {
    }

    public int getAnswerId() {
        return answerId;
    }

    public void setAnswerId(int answerId) {
        this.answerId = answerId;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
