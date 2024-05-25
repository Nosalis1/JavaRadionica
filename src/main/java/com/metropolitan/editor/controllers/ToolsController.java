package com.metropolitan.editor.controllers;

import com.metropolitan.editor.models.Tools;
import com.metropolitan.editor.utils.Util;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class ToolsController {
    @FXML
    private Button selectionButton;
    @FXML
    private Button moveButton;
    @FXML
    private Button resizeButton;
    @FXML
    private Button rotateButton;

    @FXML
    private void initialize() {
        Util.setupButton(selectionButton);
        Util.setupButton(moveButton);
        Util.setupButton(resizeButton);
        Util.setupButton(rotateButton);
    }

    @FXML
    public void onSelectionAction() {
        Tools.setCurrent(Tools.Mode.SELECT);
    }

    @FXML
    public void onMoveAction() {
        Tools.setCurrent(Tools.Mode.MOVE);
    }

    @FXML
    public void onResizeAction() {
        Tools.setCurrent(Tools.Mode.RESIZE);
    }

    @FXML
    public void onRotateAction() {
        Tools.setCurrent(Tools.Mode.ROTATE);
    }
}