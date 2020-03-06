package com.thoughtworks.answer;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class randomAnswerGenerator implements AnswerGenerator {
    private final static String[] NUMBER = {"1", "2", "3", "4", "5", "6", "7", "8", "9"};

    @Override
    public Answer generateAnswer(int digit) {
        List<String> number = Arrays.asList(NUMBER);
        Collections.shuffle(number);

        String randomNumber = String.join("", number.subList(0, digit));

        return new Answer(randomNumber);
    }
}
