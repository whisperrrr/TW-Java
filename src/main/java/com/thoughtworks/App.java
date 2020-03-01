package com.thoughtworks;

import java.util.Scanner;

import static com.thoughtworks.Machine.isRightFormat;

public class App {

    public static void main(String[] args) {
        Machine machine = new Machine(6,4);
        System.out.println(String.format("game begin...\nplease input a Please enter a %d-digit number ",machine.getDigit()));

        Scanner scanner = new Scanner(System.in);
        int inputNum = 0;
        boolean flag = false;
        while (inputNum < machine.getMaxGuess()) {

            int guessNum = scanner.nextInt();
            String guessStr = String.valueOf(guessNum);

            if (isRightFormat(guessStr)) {
                String answer = machine.getAnswer(guessStr);
                System.out.println(machine.getGuessStrHistory());
                if (machine.isRightAnswer(answer)) {
                    flag = true;
                    break;
                }
                inputNum++;
            } else {
                try {
                    throw new WrongInputException();
                } catch (WrongInputException e) {
                    StringBuilder guessStrHistory = machine.getGuessStrHistory();
                    guessStrHistory.append(guessStr).append(" ").append("Wrong input\n");
                    machine.setGuessStrHistory(guessStrHistory);
                    System.out.println(guessStrHistory);
                }
            }

        }

        if (flag) {
            System.out.println("Congratulations, you win!");
        } else {
            System.out.println(String.format("Unfortunately, you have no chance, the answer is %s",machine.getAnswerStr()));
        }

    }
}
