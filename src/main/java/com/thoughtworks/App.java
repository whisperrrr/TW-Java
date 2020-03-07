package com.thoughtworks;

import com.thoughtworks.answer.Answer;
import com.thoughtworks.exception.WrongInputException;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        int inputNum = 0;

        Game game = new Game(4, 6);
//        Game game = new Game(2, 3);
//        Game game = new Game(10, 3);
        printWelcome(game);

        Scanner scanner = new Scanner(System.in);

        while (inputNum < game.getMaxChance()) {
            String guess = scanner.nextLine();
            Answer guessNum = new Answer(guess);
            try {
                game.getValidator().validationAnswer(guessNum);
                String answer = game.getResult(guess);
                System.out.println(game.getGuessStrHistory());
                if (game.isRightAnswer(answer)) {
                    game.setWin(true);
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
        printEndGame(game);
    }

    public static void printWelcome(Game game) {
        StringBuilder welcomeWord = new StringBuilder();
        welcomeWord.append(String.format("Start guessing a %d digit number\n", game.getDigit()))
                .append(String.format("you only have %d chances", game.getMaxChance()));
        System.out.println(welcomeWord);
    }

    public static void printEndGame(Game game) {
        if (game.isWin()) {
            System.out.println("Congratulations, you win!");
        } else {
            System.out.println(String.format("Unfortunately, you have no chance, the answer is %s", game.getAnswer()));
        }
    }

}
