package com.metropolitan.editor.models;

import javafx.beans.property.*;
import javafx.scene.paint.Color;

public class ObservableElement {
    private final StringProperty name;
    private final DoubleProperty x;
    private final DoubleProperty y;

    private final DoubleProperty w;
    private final DoubleProperty h;

    private final DoubleProperty angle;
    private final StringProperty text;
    private final ObjectProperty<Color> color;

    public ObservableElement() {
        this.name = new SimpleStringProperty("");
        this.x = new SimpleDoubleProperty(0);
        this.y = new SimpleDoubleProperty(0);
        this.w = new SimpleDoubleProperty(0);
        this.h = new SimpleDoubleProperty(0);
        this.angle = new SimpleDoubleProperty(0);
        this.text = new SimpleStringProperty("");
        this.color = new SimpleObjectProperty<>(Color.BLACK);

        this.name.addListener((observable, oldValue, newValue) -> {
            Selection.getSelectedElement().setName(newValue);
            Editor.main.getLayerController().getElementsListView().refresh();
        });
        this.x.addListener((observable, oldValue, newValue) -> {
            Selection.getSelectedElement().setX(newValue.doubleValue());
            Editor.main.getContentController().forceUpdate();
        });
        this.y.addListener((observable, oldValue, newValue) -> {
            Selection.getSelectedElement().setY(newValue.doubleValue());
            Editor.main.getContentController().forceUpdate();
        });
        this.w.addListener((observable, oldValue, newValue) -> {
            Selection.getSelectedElement().setWidth(newValue.doubleValue());
            Editor.main.getContentController().forceUpdate();
        });
        this.h.addListener((observable, oldValue, newValue) -> {
            Selection.getSelectedElement().setHeight(newValue.doubleValue());
            Editor.main.getContentController().forceUpdate();
        });
        this.angle.addListener((observable, oldValue, newValue) -> {
            Selection.getSelectedElement().setAngle(newValue.doubleValue());
            Editor.main.getContentController().forceUpdate();
        });
        this.text.addListener((observable, oldValue, newValue) -> {
            if (Selection.getSelectedElement() instanceof TextElement textElement) {
                textElement.setText(newValue);
            }
            Editor.main.getContentController().forceUpdate();
        });
        this.color.addListener((observable, oldValue, newValue) -> {
            if (Selection.getSelectedElement() instanceof TextElement textElement) {
                textElement.setColor(newValue);
            }
            Editor.main.getContentController().forceUpdate();
        });
    }

    public StringProperty nameProperty() {
        return name;
    }

    public DoubleProperty xProperty() {
        return x;
    }

    public DoubleProperty yProperty() {
        return y;
    }

    public DoubleProperty wProperty() {
        return w;
    }

    public DoubleProperty hProperty() {
        return h;
    }

    public DoubleProperty angleProperty() {
        return angle;
    }

    public StringProperty textProperty() {
        return text;
    }

    public ObjectProperty<Color> colorProperty() {
        return color;
    }

    public void update(final Element element) {
        if (element != null) {
            this.name.set(element.getName());
            this.x.set(element.getX());
            this.y.set(element.getY());
            this.w.set(element.getWidth());
            this.h.set(element.getHeight());
            this.angle.set(element.getAngle());

            if(element instanceof TextElement textElement) {
                this.text.set(textElement.getText());
                this.color.set(textElement.getColor());
            }
        }
    }
}