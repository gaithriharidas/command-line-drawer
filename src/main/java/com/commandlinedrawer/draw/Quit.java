package com.commandlinedrawer.draw;

import com.commandlinedrawer.exception.CommandLineDrawerException;
import com.commandlinedrawer.model.CommandType;

import java.util.List;

public class Quit extends Command {
    @Override
    public void execute(final List<String> params) throws CommandLineDrawerException {
        if (params.size() > CommandType.getParamsCount(CommandType.QUIT)) {
            throw new CommandLineDrawerException("No parameters required for Command Q!");
        }

        System.exit(0);
    }
}
