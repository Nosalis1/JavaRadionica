package com.metropolitan.editor.models;

import com.metropolitan.editor.interfaces.IInteractive;

public class MouseHandler implements IInteractive {

    private double lastX, lastY;

    @Override
    public void onMousePressed(double x, double y) {
        if (Tools.getCurrent() == Tools.Mode.SELECT) {
            Element deepestElement = null;
            for (Element element : Editor.main.getElements()) {
                if (element.contains(x, y)) {
                    deepestElement = element;
                }
            }
            Selection.setSelectedElement(deepestElement);
        }

        this.lastX = x;
        this.lastY = y;
    }

    @Override
    public void onMouseDragged(double x, double y) {

        if (Selection.hasSelectedElement()) {
            Element element = Selection.getSelectedElement();

            double deltaX = x - lastX;
            double deltaY = y - lastY;

            switch (Tools.getCurrent()) {
                case MOVE -> element.move(deltaX, deltaY);
                case RESIZE -> element.resize(deltaX, deltaY);
                case ROTATE -> element.rotate(Math.atan2(deltaY, deltaX));
            }

            Editor.main.getContentController().forceUpdate();
            Editor.main.getLayerController().updateObservableElement();
        }

        this.lastX = x;
        this.lastY = y;
    }

    @Override
    public void onMouseReleased(double x, double y) {
        this.lastX = x;
        this.lastY = y;
    }
}