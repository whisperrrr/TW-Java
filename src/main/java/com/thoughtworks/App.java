package com.thoughtworks;

import com.thoughtworks.answer.Answer;
import com.thoughtworks.exception.WrongInputException;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        int inputNum = 0;
        boolean flag = false;

        Game game = new Game(4, 6);
        Scanner scanner = new Scanner(System.in);

        while (inputNum < game.getMaxChance()) {
            String guess = scanner.nextLine();
            Answer guessNum = new Answer(guess);
            try {
                game.getValidator().validationAnswer(guessNum);
                String answer = game.getResult(guess);
                System.out.println(game.getGuessStrHistory());
                if (game.isRightAnswer(answer)) {
                    flag = true;
                    break;
                }
                inputNum++;
            } catch (WrongInputException e) {
                StringBuilder guessStrHistory = game.getGuessStrHistory();
                guessStrHistory.append(guess).append(" ").append("Wrong input\n");
                game.setGuessStrHistory(guessStrHistory);
                System.out.println(guessStrHistory);
            }
        }

        if (flag) {
            System.out.println("Congratulations, you win!");
        } else {
            System.out.println(String.format("Unfortunately, you have no chance, the answer is %s", game.getAnswer()));
        }

    }
}
