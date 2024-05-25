package com.metropolitan.editor.controllers;

import com.metropolitan.editor.models.Editor;
import javafx.fxml.FXML;

public class MenuController {
    @FXML
    private void handleOpenButtonAction() {
        Editor.main.load();
    }

    @FXML
    private void handleSaveButtonAction() {
        Editor.main.save();
    }

    @FXML
    private void handleExitButtonAction() {
        System.exit(0);
    }

    @FXML
    private void handleAboutButtonAction() {
// TODO : Add about
    }
}
