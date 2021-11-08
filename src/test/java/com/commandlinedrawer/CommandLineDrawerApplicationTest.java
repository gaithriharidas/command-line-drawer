package com.commandlinedrawer;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CommandLineDrawerApplicationTest {
    private Object application;
    private Method validateConsoleInput;
    private Method executeCommand;

    @BeforeEach
    public void setUp() throws IllegalAccessException, InstantiationException, NoSuchMethodException {
        application = CommandLineDrawerApplication.class.newInstance();
        validateConsoleInput = application.getClass().getDeclaredMethod("validateConsoleInput", String.class);
        validateConsoleInput.setAccessible(true);

        executeCommand = application.getClass().getDeclaredMethod("executeCommand", String.class);
        executeCommand.setAccessible(true);
    }

    @Test
    public void shouldThrowExceptionWhenConsoleInputDoesntMatchPattern() {
        String errMessage = null;
        try {
            validateConsoleInput.invoke(application, "1");
        } catch (Exception e) {
            errMessage = ((InvocationTargetException) e).getTargetException().getMessage();
        }
        assertEquals("Command string is invalid.", errMessage);
    }

    @Test
    public void shouldThrowExceptionWhenConsoleInputIsInvalid() {
        String errMessage = null;
        try {
            validateConsoleInput.invoke(application, "c 15 15");
        } catch (Exception e) {
            errMessage = ((InvocationTargetException) e).getTargetException().getMessage();
        }
        assertEquals("Command C is not a valid command.", errMessage);
    }

    @Test
    public void shouldThrowExceptionIfCanvasIsNotCreatedBeforeShape() {
        String errMessage = null;
        try {
            executeCommand.invoke(application, "R 5 8 13 15");
        } catch (Exception e) {
            errMessage = ((InvocationTargetException) e).getTargetException().getMessage();
        }
        assertEquals("Canvas hasn't been created", errMessage);
    }
}
