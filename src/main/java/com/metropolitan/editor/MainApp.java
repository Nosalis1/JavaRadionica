package com.metropolitan.editor;

import com.metropolitan.editor.models.Editor;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class MainApp extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        BorderPane root = Editor.main.getEditorController().getRoot();

        Scene scene = new Scene(root);
        scene.getStylesheets().add(Objects.requireNonNull(getClass().getResource("css/styles.css")).toExternalForm());

        stage.setTitle("Image Editor");

        stage.setMaximized(true);

        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}