package com.thoughtworks.answer;

public class Answer {
    //    String getRightAnswer() throws IOException;   // 获取本轮正确答案
//    String getAnswer(String guessStr); // 获得猜测结果
//    boolean isRightAnswer(String guessAnswer);  // 是不是正确答案
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
