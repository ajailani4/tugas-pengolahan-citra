package main;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class Brightening {
    static BufferedImage image = null;

    public static void main(String[] args) {
        brightening();
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

    private static void brightening() {
        try {
            readImage("66075");

            int width = image.getWidth();
            int height = image.getHeight();

            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    Color c = new Color(image.getRGB(j, i));
                    int col = (c.getRed() + c.getGreen() + c.getBlue());
                    int hasil = col + 50;
                    if (hasil > 255) {
                        hasil = 255;
                    } else if (hasil < 0) {
                        hasil = 0;
                    }
                    Color newColor = new Color(hasil, hasil, hasil);
                    image.setRGB(j, i, newColor.getRGB());
                }
            }

            writeImage(image, "brightening_gbr1");
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }
}
