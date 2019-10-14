package com.trilogyed.U1M4SummativeBoyajianPeter.models;

import javax.validation.constraints.NotEmpty;
import java.util.Objects;

public class Answer {
    @NotEmpty
    private String question;
    private String answer;

    public Answer(String question, String answer) {
        this.question = question;
        this.answer = answer;
    }

    public Answer(String question) {
        this.question = question;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Answer answer1 = (Answer) o;
        return Objects.equals(question, answer1.question) &&
                Objects.equals(answer, answer1.answer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(question, answer);
    }

    @Override
    public String toString() {
        return "Answer{" +
                "question=" + question +
                ", answer='" + answer + '\'' +
                '}';
    }

    public Answer() {
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
