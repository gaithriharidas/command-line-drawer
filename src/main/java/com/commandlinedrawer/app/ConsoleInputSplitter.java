package com.commandlinedrawer.app;

import com.commandlinedrawer.model.CommandType;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ConsoleInputSplitter {
    private CommandType commandType;
    private List<String> params;

    public ConsoleInputSplitter() { }

    public ConsoleInputSplitter(String consoleInput) {
        /* User Input: L x1 y1 x2 y2
        *    -> commandType: L
        *    -> params: x1 y1 x2 y2 */
        String[] inputs = consoleInput.split(" ");
        commandType = CommandType.getCommandType(inputs[0]);
        params = new ArrayList<>();
        for (int i=1; i<inputs.length; i++) {
            params.add(inputs[i]);
        }
    }

    public CommandType getCommandType() {
        return commandType;
    }

    public void setCommandType(CommandType commandType) {
        this.commandType = commandType;
    }

    public List<String> getParams() {
        return params;
    }

    public void setParams(List<String> params) {
        this.params = params;
    }
}
