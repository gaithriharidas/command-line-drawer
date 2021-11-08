package com.commandlinedrawer.draw;

import com.commandlinedrawer.exception.CommandLineDrawerException;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class QuitTest {

    @Test
    public void shouldThrowExceptionWhenParamsCountIsInvalid() {
        try {
            Quit quit = new Quit();
            List<String> params = new ArrayList<>();
            params.add("param 1");
            quit.execute(params);
        } catch (Exception e) {
            assertTrue(e instanceof CommandLineDrawerException);
            assertEquals("No parameters required for Command Q!", e.getMessage());
        }
    }
}
