package main;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import java.io.IOException;

public class Boolean {
    public static void main(String[] args) throws IOException {
        int width = 321;
        int height = 481;
        BufferedImage image = null;
        try {
            File input_file = new File("D:\\gbr\\2018.jpg");
            image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);

            image = ImageIO.read(input_file);
            System.out.println("Reading complete.");
        }

        catch (IOException e) {
            System.out.println("Error: " + e);
        }

        int height1 = 321;
        BufferedImage image1 = null;
        try {
            File input_file = new File("D:\\gbr\\16004.jpg");
            image1 = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);

            image1 = ImageIO.read(input_file);
            System.out.println("Reading complete.");
        }

        catch (IOException e) {
            System.out.println("Error: " + e);
        }

        // // NOT
         try {
         for (int i = 0; i < height; i++) {
         for (int j = 0; j < width; j++) {
         Color c = new Color(image.getRGB(j, i));
         int col = (int) ((c.getRed() + c.getBlue() + c.getGreen()) / 3);
         int hasil = 255 - col;
         Color newColor = new Color(hasil, hasil, hasil);
         image.setRGB(j, i, newColor.getRGB());
         }
         }
         File output_file = new File("D:\\gbr\\not.jpg");
         ImageIO.write(image, "jpg", output_file);
         System.out.println("Writing complete.");
         }

         catch (IOException e) {
         System.out.println("Error: " + e);
         }

         // AND
         try {
            int h;
                if (height < height1) {
                    h = height;
                } else {
                    h = height1;
                }
                for (int i = 0; i < h; i++) {
                    for (int j = 0; j < width; j++) {
                     int hasil;
                        Color c = new Color(image.getRGB(j, i));
                        int col = (int) (c.getRed() + c.getBlue() + c.getGreen());
                        Color d = new Color(image1.getRGB(j, i));
                        int col1 = (int) (d.getRed() + d.getBlue() + d.getGreen());
                        if (col < col1) {
                            hasil = col;
                        } else {
                        hasil = col1;
                        }
                        if (hasil > 255) {
                            hasil = 255;
                        } else if (hasil < 0) {
                            hasil = 0;
                        }
                        Color newColor = new Color(hasil, hasil, hasil);
                        image.setRGB(j, i, newColor.getRGB());
                    }
                }
            File output_file = new File("D:\\gbr\\and.jpg");
            ImageIO.write(image, "jpg", output_file);
            System.out.println("Writing complete.");
        }

        catch (IOException e) {
         System.out.println("Error: " + e);
        }

        // OR
        try {
            int h;
            if (height < height1) {
                h = height;
            } else {
                h = height1;
            }
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < width; j++) {
                    int hasil;
                    Color c = new Color(image.getRGB(j, i));
                    int col = (int) (c.getRed() + c.getBlue() + c.getGreen());
                    Color d = new Color(image1.getRGB(j, i));
                    int col1 = (int) (d.getRed() + d.getBlue() + d.getGreen());
                    if (col > col1) {
                        hasil = col;
                    } else {
                        hasil = col1;
                    }
                    if (hasil > 255) {
                        hasil = 255;
                    } else if (hasil < 0) {
                        hasil = 0;
                    }
                    Color newColor = new Color(hasil, hasil, hasil);
                    image.setRGB(j, i, newColor.getRGB());
                }
            }
            File output_file = new File("D:\\gbr\\boolean.jpg");
            ImageIO.write(image, "jpg", output_file);
            System.out.println("Writing complete.");
        }

        catch (IOException e) {
            System.out.println("Error: " + e);
        }
    }
}
