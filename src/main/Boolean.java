package main;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import java.io.IOException;

public class Boolean {
    static BufferedImage image = null;
     static BufferedImage image1 = null;

      public static void main(String[]args){
        not();
        and();
        or();
     }
     
      private static void readImage(String fileName) {
        try {
           // File inputFile = new File("D://gbr//2018.jpg");
            File inputFile = new File("C:\\Users\\ahmad\\IdeaProjects\\TugasPengCit\\src\\assets\\" + fileName + ".jpg");
            image = ImageIO.read(inputFile);

            System.out.println("Reading complete");
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
        
        try {
           // File inputFile = new File("D://gbr//16004.jpg");
            File inputFile = new File("C:\\Users\\ahmad\\IdeaProjects\\TugasPengCit\\src\\assets\\" + fileName + ".jpg");
            image1 = ImageIO.read(inputFile);

            System.out.println("Reading complete");
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }

private static void writeImage(BufferedImage image, String fileName) {
        try {
            //File outputFile = new File("D://gbr//boolean1.jpg");
            File outputFile = new File("C:\\Users\\ahmad\\IdeaProjects\\TugasPengCit\\src\\output\\" + fileName + ".jpg");
            ImageIO.write(image, "jpg", outputFile);
            System.out.println("Writing complete");
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }
    
    private static void not(){
        readImage("2018");

           int width = image.getWidth();
           int height = image.getHeight();
        
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
        writeImage(image, "not_boolean");
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }
        

         // AND
    private static void and(){
        readImage("2018");
               
   
               int width = image.getWidth();
               int height = image.getHeight();
               int height1 = image1.getHeight();
               int width1 = image1.getHeight();
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
                writeImage(image, "and_boolean");
            } catch (Exception e) {
                System.out.println("Error: " + e);
            }
        }

        // OR
        private static void or(){
            readImage("2018");
                
    
            int width = image.getWidth();
            int height = image.getHeight();
            int height1 = image1.getHeight();
            int width1 = image1.getHeight();
            
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
            writeImage(image, "or_boolean");
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }
}
