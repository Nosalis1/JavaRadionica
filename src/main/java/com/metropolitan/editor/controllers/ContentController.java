package com.metropolitan.editor.controllers;

import com.metropolitan.editor.models.Editor;
import com.metropolitan.editor.models.Element;
import com.metropolitan.editor.views.ElementView;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;

public class ContentController {
    @FXML
    private StackPane root;
    @FXML
    private Canvas canvas;

    private GraphicsContext gc;
    private Image contentBackground;

    @FXML
    private void initialize() {
        this.gc = this.canvas.getGraphicsContext2D();
        this.canvas.widthProperty().addListener(
                observable -> this.root.setMaxSize(this.canvas.getWidth(), this.canvas.getHeight()));
    }

    public StackPane getRoot() {
        return this.root;
    }

    public Canvas getCanvas() {
        return this.canvas;
    }

    public void clearCanvas() {
        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
    }

    public void setContentBackground(final Image image) {
        this.contentBackground = image;
        this.clearCanvas();
        this.canvas.setWidth(image.getWidth());
        this.canvas.setHeight(image.getHeight());
        this.gc.drawImage(image, 0, 0, canvas.getWidth(), canvas.getHeight());
    }

    public void forceUpdate() {
        this.clearCanvas();
        this.gc.drawImage(contentBackground, 0, 0, canvas.getWidth(), canvas.getHeight());
        for (Element element : Editor.main.getElements()) {
            ElementView.display(element, gc);
        }
    }
}