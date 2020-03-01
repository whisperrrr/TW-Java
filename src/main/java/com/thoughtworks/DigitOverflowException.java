package com.thoughtworks;

public class DigitOverflowException extends RuntimeException {
    public DigitOverflowException() {
    }

    public DigitOverflowException(String message) {
        super(message);
    }
}
