package com.commandlinedrawer.app;

import com.commandlinedrawer.draw.Canvas;
import com.commandlinedrawer.draw.Command;
import com.commandlinedrawer.draw.Fill;
import com.commandlinedrawer.draw.Line;
import com.commandlinedrawer.draw.Quit;
import com.commandlinedrawer.draw.Rectangle;
import com.commandlinedrawer.exception.CommandLineDrawerException;
import com.commandlinedrawer.model.CommandType;

import java.util.List;

public class CanvasContext {
    private Command command;

    public void setCommand(final ConsoleInputSplitter consoleInput) throws CommandLineDrawerException {
        var newCommand = getCommand(consoleInput.getCommandType());
        if (this.command != null) {
            newCommand.setHeight(this.command.getHeight());
            newCommand.setWidth(this.command.getWidth());
            newCommand.setShape(this.command.getShape());
        }
        this.command = newCommand;
    }

    public void executeCommand(final List<String> params) throws CommandLineDrawerException {
        command.execute(params);
    }

    private Command getCommand(CommandType commandType) throws CommandLineDrawerException {
        var command = switch (commandType) {
            case CANVAS -> new Canvas();
            case LINE -> new Line();
            case RECTANGLE -> new Rectangle();
            case FILL -> new Fill();
            case QUIT -> new Quit();
            default -> throw new CommandLineDrawerException("Command not valid!");
        };
        return command;
    }
}
