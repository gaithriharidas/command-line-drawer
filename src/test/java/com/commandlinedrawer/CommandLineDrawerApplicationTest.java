package com.commandlinedrawer;

import com.commandlinedrawer.app.CanvasContext;
import com.commandlinedrawer.app.ConsoleInputSplitter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.test.util.ReflectionTestUtils;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CommandLineDrawerApplicationTest {
    @Mock
    private CanvasContext canvasContext;

    @Mock
    private ConsoleInputSplitter inputSplitter;

    private CommandLineDrawerApplication app;

    @BeforeEach
    public void setUp() {
        app = new CommandLineDrawerApplication(canvasContext, inputSplitter);
    }

    @Test
    public void shouldThrowExceptionWhenConsoleInputDoesntMatchPattern() {
        String errMessage = null;
        try {
            ReflectionTestUtils.invokeMethod(app, "validateConsoleInput", "1");
        } catch (Exception e) {
            errMessage = e.getCause().getMessage();
        }
        assertEquals("Command string is invalid.", errMessage);
    }

    @Test
    public void shouldThrowExceptionWhenConsoleInputIsInvalid() {
        String errMessage = null;
        try {
            ReflectionTestUtils.invokeMethod(app, "validateConsoleInput", "c 15 15");
        } catch (Exception e) {
            errMessage = e.getCause().getMessage();
        }
        assertEquals("Command c is not a valid command.", errMessage);
    }

    @Test
    public void shouldThrowExceptionIfCanvasIsNotCreatedBeforeShape() {
        String errMessage = null;
        try {
            ReflectionTestUtils.invokeMethod(app, "executeCommand", "R 5 8 13 15");
        } catch (Exception e) {
            errMessage = e.getCause().getMessage();
        }
        assertEquals("Canvas hasn't been created", errMessage);
    }
}
