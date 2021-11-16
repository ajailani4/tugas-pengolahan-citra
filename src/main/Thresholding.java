package main;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class Thresholding {
    static BufferedImage image = null;

    public static void main(String[] args) {
        threshold();
        thresholdToBinary();
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

    private static void threshold() {
        try {
            readImage("67079");

            int width = image.getWidth();
            int height = image.getHeight();

            int thresholdValue = 127;
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    Color c = new Color(image.getRGB(j, i));
                    int col = ((c.getRed()) + c.getBlue()) + (c.getGreen()) / 3;
                    Color newColor = new Color(255, 255, 255);
                    Color newColor2 = new Color(0, 0, 0);
                    if (thresholdValue > col) {
                        image.setRGB(j, i, newColor.getRGB());
                    } else {
                        image.setRGB(j, i, newColor2.getRGB());
                    }

                }
            }

            writeImage(image, "thresholding_gbr1");
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }

    private static void thresholdToBinary() {
        try {
            readImage("67079");

            int width = image.getWidth();
            int height = image.getHeight();

            int thresholdValue = 127;
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    Color c = new Color(image.getRGB(j, i));
                    int col = (int) (((0.2126 * c.getRed()) + 0.0722 * c.getBlue()) + (0.7152 * c.getGreen()));
                    Color newColor = new Color(255, 255, 255, 255);
                    Color newColor2 = new Color(0, 0, 0, 0);
                    if (col >= thresholdValue) {
                        image.setRGB(j, i, newColor.getRGB());
                    } else {
                        image.setRGB(j, i, newColor2.getRGB());
                    }

                }
            }

            writeImage(image, "thresholding_gbr2");
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }
}
