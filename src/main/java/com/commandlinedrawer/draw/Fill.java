package com.commandlinedrawer.draw;

import com.commandlinedrawer.exception.CommandLineDrawerException;

import java.util.List;

public class Fill extends Command {

    @Override
    public void execute(List<String> params) throws CommandLineDrawerException {
        final String regex = "-?\\d+?";

        if (params.size() < 3) {
            throw new CommandLineDrawerException("Command R requires 3 params.");
        } else if (!params.get(0).matches(regex)
            || !params.get(1).matches(regex)
            || params.get(2).length() != 1
        ) {
            throw new CommandLineDrawerException("Invalid params for Command F.");
        }

        //Floodfill - fills the entire canvas with c - params.get(2)
        fill(Integer.parseInt(params.get(0)), Integer.parseInt(params.get(1)), params.get(2).charAt(0));

        printShape();
    }


    /*  1. Fills entire canvas
    *   2. If (x, y) co-ordinates fall inside a drawn shape (inside a drawn rectangle),
    *      then it should only fill the drawn shape */
    private void fill(int x, int y, char c) {

    }
}
