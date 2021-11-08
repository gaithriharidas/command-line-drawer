package com.commandlinedrawer.draw;

import com.commandlinedrawer.exception.CommandLineDrawerException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CanvasTest {

    private Canvas canvas;
    List<String> params;

    @BeforeEach
    public void setUp() {
        canvas = new Canvas();

        params = new ArrayList<>();
        params.add("5");
        params.add("2");
    }

    @Test
    public void shouldThrowExceptionWhenParamsCountIsInvalid() {
        try {
            params.add("5");
            canvas.execute(params);
        } catch (Exception e) {
            assertTrue(e instanceof CommandLineDrawerException);
            assertEquals("Command C requires 2 params.", e.getMessage());
        }
    }

    @Test
    public void testExecute() throws CommandLineDrawerException {
        char[][] expected = {
            {'-','-','-','-','-'},
            {'|', 0, 0, 0, '|'},
            {'|', 0, 0, 0, '|'},
            {'-','-','-','-','-'}
        };

        canvas.execute(params);

        assertNotNull(canvas.shape);
        assertEquals(canvas.width, 5);
        assertEquals(canvas.height, 2);
        assertEquals(Arrays.deepToString(expected), Arrays.deepToString(canvas.shape));
    }
}
