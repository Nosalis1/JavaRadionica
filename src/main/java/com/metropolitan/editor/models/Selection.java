package com.metropolitan.editor.models;


import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;

public class Selection {
    private final static ObjectProperty<Element> selectedElement = new SimpleObjectProperty<>(null);

    public static ObjectProperty<Element> selectedElementProperty() {
        return selectedElement;
    }

    public static Element getSelectedElement() {
        return selectedElement.get();
    }

    public static void setSelectedElement(Element element) {
        selectedElement.set(element);
    }

    public static void clearSelectedElement() {
        selectedElement.set(null);
    }

    public static boolean hasSelectedElement() {
        return selectedElement.get() != null;
    }
}