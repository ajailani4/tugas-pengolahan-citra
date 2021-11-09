package main;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import java.io.IOException;

public class Grayscale {
    public static void main(String[] args) throws IOException {
        int width = 1600;
        int height = 1200;
        BufferedImage image = null;
        try {
            File input_file = new File("D:\\gbr\\gg.jpeg");
            image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);

            image = ImageIO.read(input_file);
            System.out.println("Reading complete.");
        }

        catch (IOException e) {
            System.out.println("Error: " + e);
        }

        try {
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    Color c = new Color(image.getRGB(j, i));
                    int col = (int) (((0.299*c.getRed()) + 0.587 *c.getBlue()) + (0.144*c.getGreen()));
                    //int col = (int) (((c.getRed()) + (c.getBlue()) + c.getGreen())/3);
                    Color newColor = new Color(col, col, col);
                    image.setRGB(j, i, newColor.getRGB());
                }
            }
            File output_file = new File("D:\\gbr\\gg_gretscale.jpeg");
            ImageIO.write(image, "jpg", output_file);
            System.out.println("Writing complete.");
        }

        catch (IOException e) {
            System.out.println("Error: " + e);
        }
    }
}
