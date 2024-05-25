package com.metropolitan.editor.views;

import com.metropolitan.editor.models.Element;
import com.metropolitan.editor.models.ImageElement;
import com.metropolitan.editor.models.TextElement;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;

public class ElementView {
    public static void display(final Element element, final GraphicsContext gc) {
        if (element instanceof ImageElement) {
            displayImage((ImageElement) element, gc);
        } else if (element instanceof TextElement) {
            displayText((TextElement) element, gc);
        }
    }

    private static void prepareRender(final Element element, final GraphicsContext gc) {
        gc.save(); // save the current state

        // translate to the center of the rectangle
        gc.translate(
                element.getX() + element.getWidth() / 2,
                element.getY() + element.getHeight() / 2
        );

        gc.rotate(element.getAngle()); // rotate render matrix
    }

    private static void finishRender(final GraphicsContext gc) {
        gc.restore(); // restore the previous state
    }

    private static void displayImage(final ImageElement element, final GraphicsContext gc) {
        prepareRender(element, gc);
        gc.drawImage(
                element.getImage(),
                -element.getWidth() / 2,
                -element.getHeight() / 2,
                element.getWidth(),
                element.getHeight()
        ); // draw the image
        finishRender(gc);
    }

    private static void displayText(final TextElement element, final GraphicsContext gc) {
        prepareRender(element, gc);
        gc.setFont(Font.font(TextElement.FONT_FAMILY, FontWeight.NORMAL, FontPosture.REGULAR, element.getHeight()));
        gc.setFill(element.getColor());

        gc.fillText(
                element.getText(),
                -element.getWidth() / 2,
                element.getHeight(),
                element.getWidth()
        );// draw the text
        finishRender(gc);
    }
}