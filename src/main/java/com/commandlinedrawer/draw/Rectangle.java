package com.commandlinedrawer.draw;

import com.commandlinedrawer.exception.CommandLineDrawerException;

import java.util.Arrays;
import java.util.List;

public class Rectangle extends Command {
    private final char HORIZONTAL_LINE_FILLER = '=';
    private final char VERTICAL_LINE_FILLER = '*';
    private int x1;
    private int x2;
    private int y1;
    private int y2;

    @Override
    public void execute(List<String> params) throws CommandLineDrawerException {
        if (params.size() < 4) {
            throw new CommandLineDrawerException("Command R requires 4 params.");
        }

        x1 = Integer.parseInt(params.get(0));
        y1 = Integer.parseInt(params.get(1));
        x2 = Integer.parseInt(params.get(2));
        y2 = Integer.parseInt(params.get(3));

        drawRectangle();

        printShape();
    }

    private void drawRectangle() {
        drawHorizontal(x1, x2, y1);
        drawVertical(x1, y1+1, y2);
        drawVertical(x2, y1+1, y2);
        drawHorizontal(x1, x2, y2);
    }

    private void drawHorizontal(int plotIndex, int endColumn, int startColumn) {
        Arrays.fill(shape[startColumn], plotIndex, (endColumn+1), HORIZONTAL_LINE_FILLER);
    }

    private void drawVertical(int plotIndex, int startRow, int endRow) {
        for (int i = startRow; i <= endRow; i++) {
            shape[i][plotIndex] = VERTICAL_LINE_FILLER;
        }
    }
}
