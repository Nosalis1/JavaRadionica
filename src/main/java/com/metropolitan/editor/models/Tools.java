package com.metropolitan.editor.models;

public class Tools {
    public enum Mode {
        SELECT,
        MOVE,
        RESIZE,
        ROTATE
    }

    private static Mode current = Mode.SELECT;

    public static Mode getCurrent() {
        return current;
    }

    public static void setCurrent(Mode mode) {
        current = mode;
    }

    public static void reset() {
        current = Mode.SELECT;
    }

}
