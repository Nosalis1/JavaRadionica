package com.metropolitan.editor.services;

import javafx.scene.canvas.Canvas;
import javafx.scene.image.Image;
import javafx.scene.image.PixelReader;
import javafx.scene.image.WritableImage;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;
import java.io.File;
import java.io.IOException;

public class ImageService {
    public static Image loadImage(String path) {
        return new Image(path);
    }

    public static Image loadImage(File file) {
        return new Image(file.getAbsolutePath());
    }

    public static void saveImage(final Canvas canvas, final File file) throws IOException {
        try {
            int width = (int) canvas.getWidth(); // Get the width of the canvas
            int height = (int) canvas.getHeight(); // Get the height of the canvas

            // Create a WritableImage with the given width and height
            WritableImage writableImage = new WritableImage(width, height);

            // Take a snapshot of the canvas and store it in the writable image
            canvas.snapshot(null, writableImage);

            // Create a BufferedImage with the same width and height
            BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);

            // Get the pixel reader from the writable image
            PixelReader pixelReader = writableImage.getPixelReader();
            // Get the raster of the image
            WritableRaster raster = image.getRaster();

            int[] pixelBuffer = new int[4]; // Buffer to hold pixel data
            // Loop through each pixel in the image
            for (int y = 0; y < height; y++) {
                for (int x = 0; x < width; x++) {
                    javafx.scene.paint.Color color = pixelReader.getColor(x, y); // Get color of pixel
                    // Store color components in the pixel buffer
                    pixelBuffer[0] = (int) (color.getRed() * 255);
                    pixelBuffer[1] = (int) (color.getGreen() * 255);
                    pixelBuffer[2] = (int) (color.getBlue() * 255);
                    pixelBuffer[3] = (int) (color.getOpacity() * 255);
                    // Set the pixel data in the raster
                    raster.setPixel(x, y, pixelBuffer);
                }
            }

            // Write the image to a file in PNG format
            ImageIO.write(image, "png", file);
        } catch (Exception e) {
            throw new IOException(e);
        }
    }
}