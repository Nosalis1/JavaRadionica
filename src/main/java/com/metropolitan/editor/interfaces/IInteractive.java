package com.metropolitan.editor.interfaces;

public interface IInteractive {
    void onMousePressed(double x, double y);

    void onMouseDragged(double x, double y);

    void onMouseReleased(double x, double y);
}