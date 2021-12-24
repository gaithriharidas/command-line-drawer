package com.commandlinedrawer.draw;

import com.commandlinedrawer.app.ApplicationContextProvider;
import com.commandlinedrawer.exception.CommandLineDrawerException;
import com.commandlinedrawer.model.CommandType;
import org.springframework.boot.SpringApplication;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Quit extends Command {
    @Override
    public void execute(final List<String> params) throws CommandLineDrawerException {
        if (params.size() > CommandType.getParamsCount(CommandType.QUIT)) {
            throw new CommandLineDrawerException("No parameters required for Command Q!");
        }

        // Shut down the application context gracefully
        SpringApplication.exit(ApplicationContextProvider.getApplicationContext(), () -> 0);

        // Exit program gracefully
        System.exit(0);
    }
}
