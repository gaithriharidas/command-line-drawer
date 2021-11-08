package com.commandlinedrawer.app;

import com.commandlinedrawer.model.CommandType;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ConsoleInputSplitterTest {
    @Test
    public void retrieveCommandTypeAndParamsFromConsoleInput() {
        final String input = "R 5 8 13 15";
        ConsoleInputSplitter inputSplitter = new ConsoleInputSplitter(input);

        String[] inputs = input.split(" ", 2);
        List<String> expected = Arrays.asList(inputs[1].split(" "));

        assertEquals(CommandType.RECTANGLE, inputSplitter.getCommandType());
        assertEquals(expected, inputSplitter.getParams());
    }
}
