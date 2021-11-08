package com.commandlinedrawer;

import com.commandlinedrawer.app.CanvasContext;
import com.commandlinedrawer.app.ConsoleInputSplitter;
import com.commandlinedrawer.exception.CommandLineDrawerException;
import com.commandlinedrawer.model.CommandType;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@SpringBootApplication
public class CommandLineDrawerApplication {
    private CanvasContext canvasContext;

    public static void main(String[] args) {
        var app = new CommandLineDrawerApplication();
        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                try {
                    System.out.print("Enter a command: ");
                    app.executeCommand(scanner.nextLine());
                } catch (CommandLineDrawerException e) {
                    System.err.println(e.getMessage());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void executeCommand(String consoleInput) throws CommandLineDrawerException {
        /*
         * 1. Check command ch in console input is C or L or R or F or Q
         *   1.1: If command ch is invalid, throw exception
         * 2. Set Canvas if canvas is created for the first time
         * 3. Split console input into command ch and params
         * */
        validateConsoleInput(consoleInput);
        ConsoleInputSplitter inputSplitter = new ConsoleInputSplitter(consoleInput);
        if (canvasContext == null) {
            if (!(inputSplitter.getCommandType().equals(CommandType.CANVAS)
                || inputSplitter.getCommandType().equals(CommandType.QUIT))
            ) {
                throw new CommandLineDrawerException("Canvas hasn't been created");
            } else {
                canvasContext = new CanvasContext();
            }
        }
        canvasContext.setCommand(inputSplitter);
        canvasContext.executeCommand(inputSplitter.getParams());
    }

    private void validateConsoleInput(String consoleInput) throws CommandLineDrawerException {
        Matcher matcher = Pattern
            .compile("[a-zA-Z]{1}(\\s\\d+)*(\\s[a-zA-z]{1})?+")
            .matcher(consoleInput);

        if (!matcher.matches()) {
            throw new CommandLineDrawerException("Command string is invalid.");
        }
        String command = consoleInput.substring(0, 1);
        if (CommandType.get(command) == null) {
            throw new CommandLineDrawerException("Command " + command + " is not a valid command.");
        }
    }
}
