package com.commandlinedrawer.draw;

import com.commandlinedrawer.exception.CommandLineDrawerException;
import org.apache.logging.log4j.util.Chars;
import org.apache.logging.log4j.util.Strings;

import java.util.List;

public abstract class Command {
    protected int width;
    protected int height;
    protected char[][] shape;

    public abstract void execute(List<String> params) throws CommandLineDrawerException;

    public char[][] getShape() {
        return shape;
    }

    public void setShape(char[][] shape) {
        this.shape = shape;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void printShape() {
        StringBuilder results = new StringBuilder();

        for (int i = 0; i < shape.length; ++i) {
            for (int j = 0; j < shape[i].length; j++) {
                results.append((shape[i][j]) == 0 ? Chars.SPACE : shape[i][j]);
            }
            results.append(Strings.LINE_SEPARATOR);
        }
        System.out.print(results.toString());
    }
}
