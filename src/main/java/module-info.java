module com.metropolitan.editor {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.metropolitan.editor to javafx.fxml;
    exports com.metropolitan.editor;
}