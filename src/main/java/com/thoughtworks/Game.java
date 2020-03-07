package com.thoughtworks;

import com.thoughtworks.answer.Answer;
import com.thoughtworks.answer.fileAnswerGenerator;
import com.thoughtworks.validator.Validator;

import java.util.LinkedHashMap;
import java.util.Map;

public class Game {
    private final int digit;  // 如何限制位数的大小   TODO
    private final static int MAX_DIGIT = 9;
    private final int maxChance;
    private final Answer answer;
    private final Validator validator;
    private boolean win = false;
    private Map<String, String> guessMap = new LinkedHashMap<>();
    private StringBuilder guessStrHistory = new StringBuilder();

    public Game(int digit, int maxChance) {
        int safeDigit = Math.min(digit, MAX_DIGIT);
        this.digit = safeDigit;
        this.maxChance = maxChance;
        this.validator = new Validator(safeDigit);
        this.answer = new fileAnswerGenerator().generateAnswer(safeDigit);
    }

    public int getDigit() {
        return digit;
    }

    public Answer getAnswer() {
        return answer;
    }

    public int getMaxChance() {
        return maxChance;
    }

    public Validator getValidator() {
        return validator;
    }

    public StringBuilder getGuessStrHistory() {
        return guessStrHistory;
    }

    public void setGuessStrHistory(StringBuilder guessStrHistory) {
        this.guessStrHistory = guessStrHistory;
    }

    public boolean isWin() {
        return win;
    }

    public void setWin(boolean win) {
        this.win = win;
    }

    // 判断是不是正确答案
    public boolean isRightAnswer(String guessResult) {
        int rightNum = Character.getNumericValue(guessResult.charAt(0));
        return rightNum == digit;
    }

    // 返回XAxB格式的结果，并更新guessMap,guessStrHistory
    public String getResult(String guessStr) {
        int valueOfA = getAValue(guessStr);
        int valueOfB = getBValue(guessStr);

        String answer = String.format("%dA%dB", valueOfA, valueOfB);
        guessMap.put(guessStr, answer);

        guessStrHistory.append(guessStr)
                .append(" ")
                .append(answer)
                .append("\n");

        return answer;
    }

    // 判断位置数字都对的的有几个
    private int getAValue(String guessStr) {
        int numOfA = 0;
        for (int i = 0; i < digit; i++) {
            char temp = guessStr.charAt(i);
            if (answer.getAnswer().indexOf(temp) == i) {
                numOfA++;
            }
        }
        return numOfA;
    }

    // 判断位置不对，数字对的有几个
    private int getBValue(String guessStr) {
        int numOfB = 0;
        for (int i = 0; i < digit; i++) {
            char temp = guessStr.charAt(i);
            int index = answer.getAnswer().indexOf(temp);
            if (index > -1 && index != i) {
                numOfB++;
            }
        }
        return numOfB;
    }

}
