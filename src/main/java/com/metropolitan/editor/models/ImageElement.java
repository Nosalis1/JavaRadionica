package com.metropolitan.editor.models;

import javafx.scene.image.Image;

public class ImageElement extends Element {
    private final Image image;

    public ImageElement(Image image) {
        this("unnamed", image);
    }

    public ImageElement(String name, Image image) {
        this(name, 0, 0, 0, image);
    }

    public ImageElement(String name, double x, double y, double angle, Image image) {
        super(name, x, y, image.getWidth(), image.getHeight(), angle);
        this.image = image;
    }

    public Image getImage() {
        return this.image;
    }

    @Override
    public boolean contains(double x, double y) {
        return x >= getX() && x <= getX() + getWidth() && y >= getY() && y <= getY() + getHeight();
    }
}