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

public class FillTest {
    private Canvas canvas;
    private Rectangle rectangle;
    private Fill fill;
    List<String> fillParams;

    @BeforeEach
    public void setUp() {
        char[][] canvasShape = {
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
        canvas.setShape(canvasShape);

        char[][] rectShape = {
            {'-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-'},
            {'|',0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,'|'},
            {'|',0,0,'=','=','=','=',0,0,0,0,0,0,0,0,0,0,0,0,'|'},
            {'|',0,0,'*',0,0,'*',0,0,0,0,0,0,0,0,0,0,0,0,'|'},
            {'|',0,0,'*',0,0,'*',0,0,0,0,0,0,0,0,0,0,0,0,'|'},
            {'|',0,0,'=','=','=','=',0,0,0,0,0,0,0,0,0,0,0,0,'|'},
            {'|',0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,'|'},
            {'-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-'}
        };

        rectangle = new Rectangle();
        rectangle.setWidth(canvas.getWidth());
        rectangle.setHeight(canvas.getHeight());
        rectangle.setShape(rectShape);

        fill = new Fill();
        fill.setWidth(rectangle.getWidth());
        fill.setHeight(rectangle.getHeight());
        fill.setShape(rectangle.getShape());

        fillParams = new ArrayList<>();
        fillParams.add("1");
        fillParams.add("1");
        fillParams.add("t");
    }

    @Test
    public void shouldThrowExceptionWhenParamsCountIsInvalid() {
        try {
            fillParams.remove(fillParams.size()-1);
            fill.execute(fillParams);
        } catch (Exception e) {
            assertTrue(e instanceof CommandLineDrawerException);
            assertEquals("Command F requires 3 params.", e.getMessage());
        }
    }

    @Test
    public void testExecute() throws CommandLineDrawerException {
        assertNotNull(rectangle.shape);
        assertEquals(rectangle.width, 20);
        assertEquals(rectangle.height, 6);

        char[][] expected = {
            {'-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-'},
            {'|','t','t','t','t','t','t','t','t','t','t','t','t','t','t','t','t','t','t','|'},
            {'|','t','t','=','=','=','=','t','t','t','t','t','t','t','t','t','t','t','t','|'},
            {'|','t','t','*',0,0,'*','t','t','t','t','t','t','t','t','t','t','t','t','|'},
            {'|','t','t','*',0,0,'*','t','t','t','t','t','t','t','t','t','t','t','t','|'},
            {'|','t','t','=','=','=','=','t','t','t','t','t','t','t','t','t','t','t','t','|'},
            {'|','t','t','t','t','t','t','t','t','t','t','t','t','t','t','t','t','t','t','|'},
            {'-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-'}
        };

        fill.execute(fillParams);

        assertEquals(Arrays.deepToString(expected), Arrays.deepToString(fill.shape));
    }
}
