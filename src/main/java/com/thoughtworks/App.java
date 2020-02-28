package com.thoughtworks;

import java.util.Scanner;

import static com.thoughtworks.Machine.isRightFormat;

public class App {

    public static void main(String[] args) {
        Machine machine = new Machine(6,4);
        System.out.println("game begin...\n please input a Please enter a four-digit number ");

        Scanner scanner = new Scanner(System.in);
        int inputNum = 0;
        while (inputNum <= machine.getMaxGuess()) {

            int guessNum = scanner.nextInt();
            String guessStr = String.valueOf(guessNum);

            if (isRightFormat(guessStr)) {
                System.out.println(machine.getAnswer(guessStr));
                inputNum++;
            }

        }
        System.out.println("Game Over");
    }



}
