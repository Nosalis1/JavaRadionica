package com.metropolitan.editor.controllers;

import javafx.fxml.FXML;
import javafx.scene.layout.BorderPane;

public class EditorController {
    @FXML
    private BorderPane root;

    @FXML
    private MenuController menuController;
    @FXML
    private ContentController contentController;

    public BorderPane getRoot() {
        return root;
    }

    public MenuController getMenuController() {
        return menuController;
    }

    public ContentController getContentController() {
        return contentController;
    }
}