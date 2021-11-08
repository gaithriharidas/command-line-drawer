package com.commandlinedrawer.draw;

import com.commandlinedrawer.exception.CommandLineDrawerException;

import java.util.Arrays;
import java.util.List;

public class Line extends Command {
    private final char LINE_FILLER = '+';
    private int startColumn;
    private int endColumn;
    private int startRow;
    private int endRow;

    @Override
    public void execute(List<String> params) throws CommandLineDrawerException {
        if (params.size() < 4) {
            throw new CommandLineDrawerException("Command L requires 4 params.");
        }

        startColumn = Integer.parseInt(params.get(0));  // x1
        startRow = Integer.parseInt(params.get(1));     // y1
        endColumn = Integer.parseInt(params.get(2));    // x2
        endRow = Integer.parseInt(params.get(3));       // y2

        drawLine();

        printShape();
    }

    private void drawLine() {
        if (startColumn == endColumn) {
            /* x-coordinates are the same, meaning plotting in the same column */
            drawVertical();
        } else if (startRow == endRow) {
            /* y-coordinates are the same, meaning plotting in the same row */
            drawHorizontal();
        } else {
            /* any other combinations will mean that the line is slanted */
            drawSlanted();
        }
    }

    private void drawHorizontal() {
        Arrays.fill(shape[startRow], startColumn, endColumn + 1, LINE_FILLER);
    }

    private void drawVertical() {
        for (int i = startRow; i <= endRow; i++) {
            shape[i][startColumn] = LINE_FILLER;
        }
    }

    private void drawSlanted() {
        double slope = (double) (endRow - startRow) / (double) (endColumn - startColumn);
        for (int i = startRow; i <= endRow; i++) {
            shape[i][(int) Math.ceil(startColumn + (slope * i))] = LINE_FILLER;
        }
    }
}
