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

    private CommandType(String commandCh, int paramsCount) {
        this.commandCh = commandCh;
        this.paramsCount = paramsCount;
    }

    public boolean equalsCommandChar(String other) {
        return commandCh.equals(other);
    }

    public String toString() {
        return this.commandCh;
    }

    public static CommandType get(String commandChar) {
        return lookup.get(commandChar);
    }
}
