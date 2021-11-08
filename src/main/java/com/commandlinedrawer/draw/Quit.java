package com.commandlinedrawer.draw;

import java.util.List;

public class Quit extends Command {
    @Override
    public void execute(final List<String> params) {
        System.exit(0);
    }
}
