package com.metropolitan.editor.models;

import com.metropolitan.editor.MainApp;
import com.metropolitan.editor.controllers.*;
import com.metropolitan.editor.services.ImageService;
import com.metropolitan.editor.utils.Util;
import javafx.beans.Observable;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.image.Image;

import java.io.File;
import java.io.IOException;
import java.util.ResourceBundle;

public class Editor {
    public static final Editor main;

    static {
        try {
            main = new Editor();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private final EditorController editorController;
    private final MenuController menuController;
    private final ContentController contentController;
    private final LayerController layerController;
    private final ToolsController toolsController;
    private final ObjectProperty<Image> image;
    private final ObservableList<Element> elements;
    private final MouseHandler mouseHandler;

    private Editor() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApp.class.getResource("fxml/editor.fxml"));
        fxmlLoader.setResources(ResourceBundle.getBundle("com.metropolitan.editor.i18n.messages"));
        fxmlLoader.load();

        this.editorController = fxmlLoader.getController();

        FXMLLoader menuFxmlLoader = new FXMLLoader(MainApp.class.getResource("fxml/menu.fxml"));
        menuFxmlLoader.setResources(ResourceBundle.getBundle("com.metropolitan.editor.i18n.messages"));
        this.editorController.getRoot().setTop(menuFxmlLoader.load());
        this.menuController = menuFxmlLoader.getController();

        FXMLLoader contentFxmlLoader = new FXMLLoader(MainApp.class.getResource("fxml/content.fxml"));
        contentFxmlLoader.setResources(ResourceBundle.getBundle("com.metropolitan.editor.i18n.messages"));
        this.editorController.getRoot().setCenter(contentFxmlLoader.load());
        this.contentController = contentFxmlLoader.getController();

        FXMLLoader layerFxmlLoader = new FXMLLoader(MainApp.class.getResource("fxml/layer.fxml"));
        layerFxmlLoader.setResources(ResourceBundle.getBundle("com.metropolitan.editor.i18n.messages"));
        this.editorController.getRoot().setRight(layerFxmlLoader.load());
        this.layerController = layerFxmlLoader.getController();

        FXMLLoader toolsFxmlLoader = new FXMLLoader(MainApp.class.getResource("fxml/tools.fxml"));
        toolsFxmlLoader.setResources(ResourceBundle.getBundle("com.metropolitan.editor.i18n.messages"));
        this.editorController.getRoot().setLeft(toolsFxmlLoader.load());
        this.toolsController = toolsFxmlLoader.getController();

        this.image = new SimpleObjectProperty<>(null);
        this.image.addListener(this::onChange);

        this.mouseHandler = new MouseHandler();

        this.contentController.getCanvas().setOnMousePressed(
                event -> this.mouseHandler.onMousePressed(event.getX(), event.getY())
        );
        this.contentController.getCanvas().setOnMouseDragged(
                event -> this.mouseHandler.onMouseDragged(event.getX(), event.getY())
        );
        this.contentController.getCanvas().setOnMouseReleased(
                event -> this.mouseHandler.onMouseReleased(event.getX(), event.getY())
        );

        this.elements = FXCollections.observableArrayList();
        this.layerController.getElementsListView().setItems(elements);
        this.elements.addListener(this::onElementChange);

        Selection.selectedElementProperty().addListener(this::onSelectionChange);
    }

    private void onSelectionChange(Observable observable) {
        if (this.layerController.getElementsListView().getSelectionModel().getSelectedItem() != Selection.getSelectedElement()) {
            this.layerController.getElementsListView().getSelectionModel().select(Selection.getSelectedElement());
        }
    }

    private void onElementChange(Observable observable) {
        this.contentController.forceUpdate();
    }

    private void onChange(ObservableValue<? extends Image> observableValue, Image oldImage, Image newImage) {
        if (newImage != null) {
            this.contentController.setContentBackground(newImage);
        }
    }

    public EditorController getEditorController() {
        return editorController;
    }

    public MenuController getMenuController() {
        return menuController;
    }

    public ContentController getContentController() {
        return contentController;
    }

    public LayerController getLayerController() {
        return layerController;
    }

    public ToolsController getToolsController() {
        return toolsController;
    }

    public ObservableList<Element> getElements() {
        return elements;
    }

    public void load() {
        File file = Util.Files.selectFile();
        if (file == null) {
            Util.displayAlert("Error", "Error", Alert.AlertType.ERROR);
            return;
        }
        this.image.set(ImageService.loadImage(file));
        Util.displayAlert("Success", "Success", Alert.AlertType.INFORMATION);
    }

    public void save() {
        File file = Util.Files.selectSaveFile();
        try {
            ImageService.saveImage(this.contentController.getCanvas(), file);
        } catch (IOException e) {
            Util.displayAlert("Error", "Error", Alert.AlertType.ERROR);
            return;
        }
        Util.displayAlert("Success", "Success", Alert.AlertType.INFORMATION);
    }
}