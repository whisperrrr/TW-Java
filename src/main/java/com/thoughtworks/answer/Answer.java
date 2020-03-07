package com.thoughtworks.answer;

public class Answer {
    private String answer;

    public Answer(String answer) {
        this.answer = answer;
    }

    public String getAnswer() {
        return answer;
    }

    public int getLength() {
        return answer.length();
    }

    @Override
    public String toString() {
        return answer;
    }
}
