package com.metropolitan.editor.models;

import com.metropolitan.editor.interfaces.IDisplayable;

public abstract class Element implements IDisplayable {
    private String name;
    private double x, y, width, height, angle;

    public Element() {
        this("unnamed", 0, 0, 100, 100, 0);
    }

    public Element(String name, double x, double y, double width, double height, double angle) {
        this.name = name;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.angle = angle;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getAngle() {
        return angle;
    }

    public void setAngle(double angle) {
        this.angle = angle;
    }

    public void move(double x, double y) {
        this.x += x;
        this.y += y;
    }

    public void resize(double width, double height) {
        this.width += width;
        this.height += height;
    }

    public void rotate(double angle) {
        this.angle += angle;
    }

    @Override
    public String toString() {
        return this.name;
    }
}