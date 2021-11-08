package com.commandlinedrawer.app;

import com.commandlinedrawer.draw.Canvas;
import com.commandlinedrawer.draw.Command;
import com.commandlinedrawer.draw.Fill;
import com.commandlinedrawer.draw.Line;
import com.commandlinedrawer.draw.Quit;
import com.commandlinedrawer.draw.Rectangle;
import com.commandlinedrawer.model.CommandType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class CanvasContextTest {

    private Object canvasContext;
    private Method getCommand;
    private ConsoleInputSplitter inputSplitter;
    private Command command;

    @BeforeEach
    public void setUp() throws IllegalAccessException, InstantiationException, NoSuchMethodException {
        canvasContext = CanvasContext.class.newInstance();
        getCommand = canvasContext.getClass().getDeclaredMethod("getCommand", CommandType.class);
        getCommand.setAccessible(true);
    }

    @Test
    public void verifyCreateCanvas() throws IllegalAccessException, InvocationTargetException {
        inputSplitter = new ConsoleInputSplitter("C 15 15");
        command = (Command) getCommand.invoke(canvasContext, inputSplitter.getCommandType());
        assertTrue(command instanceof Canvas);
    }

    @Test
    public void verifyCreateRectangle() throws IllegalAccessException, InvocationTargetException {
        inputSplitter = new ConsoleInputSplitter("R 5 8 13 15");
        command = (Command) getCommand.invoke(canvasContext, inputSplitter.getCommandType());
        assertTrue(command instanceof Rectangle);
    }

    @Test
    public void verifyFill() throws IllegalAccessException, InvocationTargetException {
        inputSplitter = new ConsoleInputSplitter("F 1 14 t");
        command = (Command) getCommand.invoke(canvasContext, inputSplitter.getCommandType());
        assertTrue(command instanceof Fill);
    }

    @Test
    public void verifyCreateLine() throws IllegalAccessException, InvocationTargetException {
        inputSplitter = new ConsoleInputSplitter("L 5 6 9 6");
        command = (Command) getCommand.invoke(canvasContext, inputSplitter.getCommandType());
        assertTrue(command instanceof Line);
    }

    @Test
    public void verifyQuit() throws IllegalAccessException, InvocationTargetException {
        inputSplitter = new ConsoleInputSplitter("Q");
        command = (Command) getCommand.invoke(canvasContext, inputSplitter.getCommandType());
        assertTrue(command instanceof Quit);
    }
}

