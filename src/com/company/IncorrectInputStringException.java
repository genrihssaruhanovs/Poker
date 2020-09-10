package com.company;

public class IncorrectInputStringException extends RuntimeException {
    public IncorrectInputStringException(String message) {
        super("Wrong input string: " + message);
    }
}
