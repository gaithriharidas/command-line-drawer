package com.commandlinedrawer.draw;

import com.commandlinedrawer.exception.CommandLineDrawerException;

import java.util.Arrays;
import java.util.List;

public class Canvas extends Command {
    private final char HORIZONTAL_LINE_FILLER = '-';
    private final char VERTICAL_LINE_FILLER = '|';

    @Override
    public void execute(List<String> params) throws CommandLineDrawerException {
        if (params.size() < 2) {
            throw new CommandLineDrawerException("Command C requires 2 params.");
        }

        width = Integer.parseInt(params.get(0));
        height = Integer.parseInt(params.get(1));

        setShape(new char[height+2][width]);

        drawCanvas();

        printShape();
    }

    private void drawCanvas() {
        drawHorizontal(0);
        drawVertical(0);
        drawVertical(width-1);
        drawHorizontal(height+1);
    }

    private void drawHorizontal(int startIndex) {
        Arrays.fill(shape[startIndex], 0, width, HORIZONTAL_LINE_FILLER);
    }

    private void drawVertical(int startIndex) {
        for (int i = 1; i < height+1; i++) {
            shape[i][startIndex] = VERTICAL_LINE_FILLER;
        }
    }
}
