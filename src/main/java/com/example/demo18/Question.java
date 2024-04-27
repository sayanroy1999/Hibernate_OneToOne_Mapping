package com.example.demo18;

import jakarta.persistence.*;

@Entity
public class Question {
    @Id
    @Column(name="question_id")
    private int questionId;
    private String question;
    @OneToOne(fetch = FetchType.EAGER)
    //@JoinColumn(name = "a_id") //The answer id is called join column
    private Answer answer; // This is unidirectional, that is only question table will have the answer ID. However if we also set the question column in answer, then that will be multidirectional

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public Answer getAnswer() {
        return answer;
    }

    public void setAnswer(Answer answer) {
        this.answer = answer;
    }

    public Question(int questionId, String question, Answer answer) {
        this.questionId = questionId;
        this.question = question;
        this.answer = answer;
    }

    public Question() {
    }
}
