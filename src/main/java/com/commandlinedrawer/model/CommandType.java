package com.commandlinedrawer.model;

import java.util.HashMap;
import java.util.Map;

public enum CommandType {
    CANVAS("C", 2),
    LINE("L", 4),
    RECTANGLE("R", 4),
    FILL("F", 3),
    QUIT("Q", 0);

    private static final Map<String, CommandType> lookup = new HashMap<>();

    static {
        for (CommandType t : CommandType.values()) {
            lookup.put(t.commandCh, t);
        }
    }

    private final String commandCh;
    private final int paramsCount;

    CommandType(String commandCh, int paramsCount) {
        this.commandCh = commandCh;
        this.paramsCount = paramsCount;
    }

    public static CommandType getCommandType(String commandChar) {
        return lookup.get(commandChar);
    }

    public static int getParamsCount(CommandType c) { return lookup.get(c.commandCh).paramsCount; }
}
