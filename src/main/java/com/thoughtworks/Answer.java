package com.thoughtworks;

import java.io.IOException;

public interface Answer {
    String getRightAnswer() throws IOException;   // 获取本轮正确答案
    String getAnswer(String guessStr); // 获得猜测结果
    boolean isRightAnswer(String guessAnswer);  // 是不是正确答案
}
