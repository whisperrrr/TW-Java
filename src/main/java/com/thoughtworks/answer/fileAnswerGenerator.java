package com.thoughtworks.answer;

import com.thoughtworks.answer.AnswerGenerator;
import com.thoughtworks.exception.WrongInputException;
import com.thoughtworks.validator.Validator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Path;
import java.nio.file.Paths;


public class fileAnswerGenerator implements AnswerGenerator {
    private static final Path ANSWER_FILE_PATH = Paths.get("answer.txt");

    @Override
    public Answer generateAnswer(int digit) {
        Validator validator = new Validator(digit);
        ClassLoader classLoader = getClass().getClassLoader();
        try (InputStream is = classLoader.getResourceAsStream(ANSWER_FILE_PATH.toString());
             BufferedReader reader = new BufferedReader(new InputStreamReader(is))) {
            String number = reader.readLine();

            Answer answer = new Answer(number);
            validator.validationAnswer(answer);
            return answer;
        } catch (IOException | WrongInputException e) {
            randomAnswerGenerator randomAnswerGenerator = new randomAnswerGenerator();
            return randomAnswerGenerator.generateAnswer(digit);
        }
    }
}

