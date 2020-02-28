package com.thoughtworks;

public class WrongInputException extends RuntimeException {
    public WrongInputException() {
    }

    public WrongInputException(String message) {
        super(message);
    }
}
