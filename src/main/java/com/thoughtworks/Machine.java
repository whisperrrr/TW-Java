package com.thoughtworks;




import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

public class Machine {
    private final String answer;
    private final int digit;
    private final int maxGuess;
    private Map<String, String> guessMap = new LinkedHashMap<>();

    public Machine(int maxGuess, int digit) {
        String answer;
        try {
            answer = getRightAnswer();
        } catch (IOException e) {
            answer = getRandomAnswer();
        }
        this.answer = answer;
        this.maxGuess = maxGuess;
        this.digit = digit;
    }

    public int getMaxGuess() {
        return maxGuess;
    }

    public Map<String, String> getGuessMap() {
        return guessMap;
    }

    // 判断是不是正确答案
    public boolean isRightAnswer(String guessStr) {
        String str = getAnswer(guessStr);
        int rightNum = Character.getNumericValue(str.charAt(0));
        return rightNum == digit;
    }

    // 返回XAxB格式的结果，并更新guessMap
    public String getAnswer(String guessStr) {
        int valueOfA = getAValue(guessStr);
        int valueOfB = getBValue(guessStr);

        String answer = String.format("%dA%dB", valueOfA, valueOfB);
        guessMap.put(guessStr, answer);

        return answer;
    }

    // 判断位置数字都对的的有几个
    private int getAValue(String guessStr) {
        int numOfA = 0;
        for (int i = 0; i < digit; i++) {
            char temp = guessStr.charAt(i);
            if (answer.indexOf(temp) == i) {
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
            int index = answer.indexOf(temp);
            if (index > -1 && index != i) {
                numOfB++;
            }
        }
        return numOfB;
    }

    // 从answer.txt里获取答案，如果没有，则随机生成
    public static String getRightAnswer() throws IOException{
        String path = "src/main/resources/answer.txt";
        try(FileInputStream file = new FileInputStream(path)) {
            InputStreamReader reader = new InputStreamReader(file);
            BufferedReader bufferedReader = new BufferedReader(reader);
            String strTmp = bufferedReader.readLine();
            if (!isRightFormat(strTmp)) {
                strTmp = getRightAnswer();
            }
            return strTmp;
        }
    }

    private String getRandomAnswer() {
//        // 考虑输入位数多了的情况
//        if (digit > 9) {
//
//        }
        Set<String> set = new HashSet<>();
        Random random = new Random();
        while (set.size() < digit) {
            int temp = random.nextInt(10);
            set.add(String.valueOf(temp));
        }
        List<String> answerList = new ArrayList<>(set);
        return String.join("",answerList);
    }
    // 检测正确的格子格式
    public static boolean isRightFormat(String str) {
        String[] strList = str.split("");
        int length = strList.length;

        HashSet<String> strSet = new HashSet<>(Arrays.asList(strList));
        int size = strSet.size();

        return length == size;
    }


}
