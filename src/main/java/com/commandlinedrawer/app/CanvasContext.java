package com.commandlinedrawer.app;

import com.commandlinedrawer.draw.Canvas;
import com.commandlinedrawer.draw.Command;
import com.commandlinedrawer.draw.Fill;
import com.commandlinedrawer.draw.Line;
import com.commandlinedrawer.draw.Quit;
import com.commandlinedrawer.draw.Rectangle;
import com.commandlinedrawer.exception.CommandLineDrawerException;
import com.commandlinedrawer.model.CommandType;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CanvasContext {
    private Command command;
    private Canvas canvas;
    private Line line;
    private Rectangle rectangle;
    private Fill fill;
    private Quit quit;

    public CanvasContext() {
        this.canvas = new Canvas();
        this.line = new Line();
        this.rectangle = new Rectangle();
        this.fill = new Fill();
        this.quit = new Quit();
    }

    private Command getCommand(CommandType commandType) throws CommandLineDrawerException {
        var command = switch (commandType) {
            case CANVAS -> canvas;
            case LINE -> line;
            case RECTANGLE -> rectangle;
            case FILL -> fill;
            case QUIT -> quit;
            default -> throw new CommandLineDrawerException("Command not valid!");
        };
        return command;
    }

    public void setCommand(final ConsoleInputSplitter consoleInput) throws CommandLineDrawerException {
        var newCommand = getCommand(consoleInput.getCommandType());
        if (command != null) {
            newCommand.setHeight(command.getHeight());
            newCommand.setWidth(command.getWidth());
            newCommand.setShape(command.getShape());
        }
        this.command = newCommand;
    }

    public void executeCommand(final List<String> params) throws CommandLineDrawerException {
        command.execute(params);
    }
}
