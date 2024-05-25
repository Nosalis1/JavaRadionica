package com.metropolitan.editor.controllers;

import com.metropolitan.editor.models.*;
import com.metropolitan.editor.services.ImageService;
import com.metropolitan.editor.utils.Util;
import com.metropolitan.editor.views.ElementCell;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.util.Callback;
import javafx.util.converter.NumberStringConverter;

import java.io.File;

public class LayerController {
    @FXML
    private ListView<Element> elementsListView;

    @FXML
    private Button addImageButton;
    @FXML
    private Button addTextButton;
    @FXML
    private Button removeButton;


    @FXML
    private TextField nameField;
    @FXML
    private TextField xField;
    @FXML
    private TextField yField;
    @FXML
    private TextField wField;
    @FXML
    private TextField hField;
    @FXML
    private TextField angleField;
    @FXML
    private TextField textField;
    @FXML
    private ColorPicker colorPicker;

    private final ObservableElement observableElement = new ObservableElement();

    public Button getAddImageButton() {
        return this.addImageButton;
    }

    public Button getAddTextButton() {
        return this.addTextButton;
    }

    public Button getRemoveButton() {
        return this.removeButton;
    }

    public TextField getNameField() {
        return this.nameField;
    }

    public TextField getXField() {
        return this.xField;
    }

    public TextField getYField() {
        return this.yField;
    }

    public TextField getWField() {
        return this.wField;
    }

    public TextField getHField() {
        return this.hField;
    }

    public TextField getAngleField() {
        return this.angleField;
    }

    public TextField getTextField() {
        return this.textField;
    }

    public ColorPicker getColorPicker() {
        return this.colorPicker;
    }

    public ObservableElement getObservableElement() {
        return this.observableElement;
    }

    @FXML
    private void initialize() {
        this.elementsListView.setCellFactory(elementListView -> new ElementCell());

        this.elementsListView.getSelectionModel().selectedItemProperty().addListener(
                observable -> Selection.setSelectedElement(elementsListView.getSelectionModel().getSelectedItem())
        );
        Util.setupButton(addImageButton);
        Util.setupButton(addTextButton);
        Util.setupButton(removeButton);

        NumberStringConverter nsc = new NumberStringConverter();
        nameField.textProperty().bindBidirectional(observableElement.nameProperty());
        xField.textProperty().bindBidirectional(observableElement.xProperty(), nsc);
        yField.textProperty().bindBidirectional(observableElement.yProperty(), nsc);
        wField.textProperty().bindBidirectional(observableElement.wProperty(), nsc);
        hField.textProperty().bindBidirectional(observableElement.hProperty(), nsc);
        angleField.textProperty().bindBidirectional(observableElement.angleProperty(), nsc);
        textField.textProperty().bindBidirectional(observableElement.textProperty());
        colorPicker.valueProperty().bindBidirectional(observableElement.colorProperty());

        Selection.selectedElementProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue == null) {
                nameField.setEditable(false);
                xField.setEditable(false);
                yField.setEditable(false);
                wField.setEditable(false);
                hField.setEditable(false);
                angleField.setEditable(false);
                textField.setEditable(false);
                colorPicker.setEditable(false);
            } else {
                if (newValue instanceof ImageElement) {
                    textField.setEditable(false);
                    colorPicker.setEditable(false);
                } else if (newValue instanceof TextElement) {
                    textField.setEditable(true);
                    colorPicker.setEditable(true);
                }
            }
            this.observableElement.update(newValue);
        });
    }


    public void updateObservableElement() {
        observableElement.update(Selection.getSelectedElement());
    }

    public ListView<Element> getElementsListView() {
        return elementsListView;
    }

    @FXML
    public void onAddImageAction() {
        File file = Util.Files.selectFile();
        Image image = ImageService.loadImage(file);
        Editor.main.getElements().add(new ImageElement(image));
    }

    @FXML
    public void onAddTextAction() {
        Editor.main.getElements().add(new TextElement("Hello World!"));
    }

    @FXML
    public void onRemoveAction() {
        Editor.main.getElements().remove(elementsListView.getSelectionModel().getSelectedItem());
    }
}