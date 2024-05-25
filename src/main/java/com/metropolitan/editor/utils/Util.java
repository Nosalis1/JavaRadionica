package com.metropolitan.editor.utils;

import com.metropolitan.editor.MainApp;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;

import java.io.File;
import java.util.Objects;

public class Util {

    public static void displayAlert(String title, String message, Alert.AlertType type) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
    public static void setupButton(Button button) {
        Image image = new Image(Objects.requireNonNull(MainApp.class.getResourceAsStream("images/" + button.getText())));
        ImageView imageView = new ImageView(image);
        imageView.setFitWidth(24);
        imageView.setFitHeight(24);
        imageView.setPreserveRatio(true);
        button.setGraphic(imageView);
        button.setText(null);
    }

    public static class Files {
        public static File selectFile() {
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Open Image File");
            fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("PNG Files", "*.png"));
            return fileChooser.showOpenDialog(null);
        }
        public static File selectSaveFile(){
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Save Image File");
            fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("PNG Files", "*.png"));
            return fileChooser.showSaveDialog(null);
        }
    }
}
