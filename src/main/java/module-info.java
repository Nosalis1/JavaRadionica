module com.metropolitan.editor {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens com.metropolitan.editor to javafx.fxml;
    opens com.metropolitan.editor.controllers to javafx.fxml;
    exports com.metropolitan.editor;
    exports com.metropolitan.editor.controllers;
    exports com.metropolitan.editor.models;
    exports com.metropolitan.editor.views;
}