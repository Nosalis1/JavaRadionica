package com.metropolitan.editor.models;

import javafx.scene.paint.Color;

public class TextElement extends Element {
    public static final String FONT_FAMILY = "Arial";

    private String text;
    private Color color;

    public TextElement(String text) {
        this("unnamed", text);
    }

    public TextElement(String name, String text) {
        this(name, 0, 0, 0, text);
    }

    public TextElement(String name, double x, double y, double angle, String text) {
        super(name, x, y, 100, 20, angle);
        this.text = text;
    }

    public String getText() {
        return this.text;
    }
    public Color getColor() {
        return this.color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public boolean contains(double x, double y) {
        return x >= getX() && x <= getX() + getWidth() && y >= getY() && y <= getY() + getHeight();
    }
}
