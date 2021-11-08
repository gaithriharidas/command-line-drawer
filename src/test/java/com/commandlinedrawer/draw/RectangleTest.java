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

public class RectangleTest {
    private Canvas canvas;
    private Rectangle rectangle;
    List<String> rectParams;

    @BeforeEach
    public void setUp() {
        char[][] shape = {
            {'-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-'},
            {'|',0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,'|'},
            {'|',0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,'|'},
            {'|',0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,'|'},
            {'|',0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,'|'},
            {'|',0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,'|'},
            {'|',0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,'|'},
            {'-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-'}
        };

        canvas = new Canvas();
        canvas.setWidth(20);
        canvas.setHeight(6);
        canvas.setShape(shape);

        rectangle = new Rectangle();
        rectangle.setWidth(canvas.getWidth());
        rectangle.setHeight(canvas.getHeight());
        rectangle.setShape(canvas.getShape());

        rectParams = new ArrayList<>();
        rectParams.add("4");
        rectParams.add("2");
        rectParams.add("6");
        rectParams.add("5");
    }

    @Test
    public void shouldThrowExceptionWhenParamsCountIsInvalid() {
        try {
            rectParams.remove(rectParams.size()-1);
            rectangle.execute(rectParams);
        } catch (Exception e) {
            assertTrue(e instanceof CommandLineDrawerException);
            assertEquals("Command R requires 4 params.", e.getMessage());
        }
    }

    @Test
    public void testExecute() throws CommandLineDrawerException {
        assertNotNull(canvas.shape);
        assertEquals(canvas.width, 20);
        assertEquals(canvas.height, 6);

        char[][] expected = {
            {'-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-'},
            {'|',0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,'|'},
            {'|',0,0,0,'=','=','=',0,0,0,0,0,0,0,0,0,0,0,0,'|'},
            {'|',0,0,0,'*',0,'*',0,0,0,0,0,0,0,0,0,0,0,0,'|'},
            {'|',0,0,0,'*',0,'*',0,0,0,0,0,0,0,0,0,0,0,0,'|'},
            {'|',0,0,0,'=','=','=',0,0,0,0,0,0,0,0,0,0,0,0,'|'},
            {'|',0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,'|'},
            {'-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-'}
        };

        rectangle.execute(rectParams);

        assertEquals(rectangle.width, canvas.width);
        assertEquals(rectangle.height, canvas.height);
        assertEquals(Arrays.deepToString(expected), Arrays.deepToString(rectangle.shape));
    }
}
