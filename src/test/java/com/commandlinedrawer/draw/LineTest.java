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

public class LineTest {
    private Canvas canvas;
    private Line line;
    List<String> lineParams;

    @BeforeEach
    public void setUp() {
         char[][] shape = {
            {'-','-','-','-','-','-','-','-','-','-','-','-','-','-','-'},
            {'|',0,0,0,0,0,0,0,0,0,0,0,0,0,'|'},
            {'|',0,0,0,0,0,0,0,0,0,0,0,0,0,'|'},
            {'|',0,0,0,0,0,0,0,0,0,0,0,0,0,'|'},
            {'-','-','-','-','-','-','-','-','-','-','-','-','-','-','-'}
        };

        canvas = new Canvas();
        canvas.setWidth(15);
        canvas.setHeight(3);
        canvas.setShape(shape);

        line = new Line();
        line.setWidth(canvas.getWidth());
        line.setHeight(canvas.getHeight());
        line.setShape(shape);

        lineParams = new ArrayList<>();
        lineParams.add("5");
        lineParams.add("3");
        lineParams.add("9");
        lineParams.add("3");
    }

    @Test
    public void shouldThrowExceptionWhenParamsCountIsInvalid() {
        try {
            lineParams.remove(lineParams.size()-1);
            line.execute(lineParams);
        } catch (Exception e) {
            assertTrue(e instanceof CommandLineDrawerException);
            assertEquals("Command L requires 4 params.", e.getMessage());
        }
    }

    @Test
    public void testExecute() throws CommandLineDrawerException {
        assertNotNull(canvas.shape);
        assertEquals(canvas.width, 15);
        assertEquals(canvas.height, 3);

        char[][] expected = {
            {'-','-','-','-','-','-','-','-','-','-','-','-','-','-','-'},
            {'|',0,0,0,0,0,0,0,0,0,0,0,0,0,'|'},
            {'|',0,0,0,0,0,0,0,0,0,0,0,0,0,'|'},
            {'|',0,0,0,0,'+','+','+','+','+',0,0,0,0,'|'},
            {'-','-','-','-','-','-','-','-','-','-','-','-','-','-','-'}
        };

        line.execute(lineParams);

        assertEquals(Arrays.deepToString(expected), Arrays.deepToString(line.shape));
    }
}
