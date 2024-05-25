package com.metropolitan.editor.views;

import com.metropolitan.editor.models.Element;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;

public class ElementCell extends javafx.scene.control.ListCell<Element> {
    private final Button upButton;
    private final Button downButton;
    private final HBox buttons;

    {
        upButton = new Button("\u25B2");
        upButton.setOnAction(event -> {
            int index = getIndex();
            if (index > 0) {
                Element element = getItem();
                getListView().getItems().remove(index);
                getListView().getItems().add(index - 1, element);
                getListView().getSelectionModel().select(index - 1);
            }
        });

        downButton = new Button("\u25BC");
        downButton.setOnAction(event -> {
            int index = getIndex();
            if (index < getListView().getItems().size() - 1) {
                Element element = getItem();
                getListView().getItems().remove(index);
                getListView().getItems().add(index + 1, element);
                getListView().getSelectionModel().select(index + 1);
            }
        });

        buttons = new HBox(upButton, downButton);
    }

    @Override
    protected void updateItem(Element item, boolean empty) {
        super.updateItem(item, empty);
        if (item == null || empty) {
            setText(null);
            setGraphic(null);
        } else {
            setText(item.toString());
            setGraphic(buttons);
        }
    }
}
