package com.commandlinedrawer.exception;

public class CommandLineDrawerException extends Exception {
    private static final long serialVersionUID = 1L;

    public CommandLineDrawerException(String message) {
        super(message);
    }

    public CommandLineDrawerException(String message, Throwable th) {
        super(message, th);
    }
}
