package main;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class Grayscale {
    static BufferedImage image = null;

    public static void main(String[] args) {
        grayscale();
    }

    private static void readImage(String fileName) {
        try {
            File inputFile = new File("C:\\Users\\ahmad\\IdeaProjects\\TugasPengCit\\src\\assets\\" + fileName + ".jpg");
            image = ImageIO.read(inputFile);

            System.out.println("Reading complete");
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }

    private static void writeImage(BufferedImage image, String fileName) {
        try {
            File outputFile = new File("C:\\Users\\ahmad\\IdeaProjects\\TugasPengCit\\src\\output\\" + fileName + ".jpg");
            ImageIO.write(image, "jpg", outputFile);
            System.out.println("Writing complete");
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }

    private static void grayscale() {
        try {
            readImage("16004");

            int width = image.getWidth();
            int height = image.getHeight();

            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    Color c = new Color(image.getRGB(j, i));
//                    int col = (int) (((0.299 * c.getRed()) + 0.587 * c.getBlue()) + (0.144 * c.getGreen()));
                    int col = ((c.getRed()) + (c.getBlue()) + c.getGreen()) / 3;
                    Color newColor = new Color(col, col, col);
                    image.setRGB(j, i, newColor.getRGB());
                }
            }

            writeImage(image, "grayscale_gbr1");
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }
}
