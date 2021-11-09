package tugaspengcit;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import java.io.IOException;

public class Aritmatika {
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

         // penjumlahan
         try {
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                Color c = new Color(image.getRGB(j, i));
                Color c1 = new Color(image.getRGB(j, i));
                int col = (int) (c.getRed() + c.getGreen() + c.getBlue());
                int col1 = (int) (c1.getRed() + c1.getGreen() + c1.getBlue());
                int hasil =(int) ((col + col1)/2);
                
                    if (hasil > 255) {
                    hasil = 255;
                    } 
                    else if (hasil < 0) {
                    hasil = 0;
                    }else{
                    hasil = hasil;
                    }    
                Color newColor = new Color(hasil, hasil, hasil);
                image.setRGB(j, i, newColor.getRGB());
                }
            }
         File output_file = new File("D:\\gbr\\penjumlahan.jpg");
         ImageIO.write(image, "jpg", output_file);
         System.out.println("Writing complete.");
        }

        catch (IOException e) {
        System.out.println("Error: " + e);
        }

         // pengurangan
         try {
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                Color c = new Color(image.getRGB(j, i));
                Color c1 = new Color(image.getRGB(j, i));
                int col = (int) (c.getRed() + c.getGreen() + c.getBlue());
                int col1 = (int) (c1.getRed() + c1.getGreen() + c1.getBlue());
                int hasil = col - col1;
                
                    if (hasil > 255) {
                    hasil = 255;
                    } else if (hasil < 0) {
                    hasil = 0;
                    }
                    
                Color newColor = new Color(hasil, hasil, hasil);
                image.setRGB(j, i, newColor.getRGB());
                }
            }
        File output_file = new File("D:\\gbr\\pengurangan.png");
        ImageIO.write(image, "png", output_file);
        System.out.println("Writing complete.");
        }

        catch (IOException e) {
        System.out.println("Error: " + e);
        }

        // // perkalian
        // try {
        // for (int i = 0; i < height; i++) {
        // for (int j = 0; j < width; j++) {
        // Color c = new Color(image.getRGB(j, i));
        // Color c1 = new Color(image.getRGB(j, i));
        // int col = (int) (c.getRed() + c.getGreen() + c.getBlue());
        // int col1 = (int) (c1.getRed() + c1.getGreen() + c1.getBlue());
        // int hasil = col * col1;
        // if (hasil > 255) {
        // hasil = 255;
        // } else if (hasil < 0) {
        // hasil = 0;
        // }
        // Color newColor = new Color(hasil, hasil, hasil);
        // image.setRGB(j, i, newColor.getRGB());
        // }
        // }
        // File output_file = new File("D:\\gbr\\perkalian.png");
        // ImageIO.write(image, "png", output_file);
        // System.out.println("Writing complete.");
        // }

        // catch (IOException e) {
        // System.out.println("Error: " + e);
        // }

        // // skalar tambah
        // try {
        // for (int i = 0; i < height; i++) {
        // for (int j = 0; j < width; j++) {
        // Color c = new Color(image.getRGB(j, i));
        // int col = (int) (c.getRed() + c.getGreen() + c.getBlue());
        // int hasil = col + 100;
        // if (hasil > 255) {
        // hasil = 255;
        // } else if (hasil < 0) {
        // hasil = 0;
        // }
        // Color newColor = new Color(hasil, hasil, hasil);
        // image.setRGB(j, i, newColor.getRGB());
        // }
        // }
        // File output_file = new File("D:\\gbr\\skalar_tambah.jpg");
        // ImageIO.write(image, "jpg", output_file);
        // System.out.println("Writing complete.");
        // }

        // catch (IOException e) {
        // System.out.println("Error: " + e);
        // }

        // skalar kurang
        // try {
        // for (int i = 0; i < height; i++) {
        // for (int j = 0; j < width; j++) {
        // Color c = new Color(image.getRGB(j, i));
        // int col = (int) (c.getRed() + c.getGreen() + c.getBlue());
        // int hasil = col - 100;
        // if (hasil > 255) {
        // hasil = 255;
        // } else if (hasil < 0) {
        // hasil = 0;
        // }
        // Color newColor = new Color(hasil, hasil, hasil);
        // image.setRGB(j, i, newColor.getRGB());
        // }
        // }
        // File output_file = new File("D:\\gbr\\skalar_kurang.jpg");
        // ImageIO.write(image, "jpg", output_file);
        // System.out.println("Writing complete.");
        // }

        // catch (IOException e) {
        // System.out.println("Error: " + e);
        // }

        // // skalar kali
        // try {
        // for (int i = 0; i < height; i++) {
        // for (int j = 0; j < width; j++) {
        // Color c = new Color(image.getRGB(j, i));
        // int col = (int) (c.getRed() + c.getGreen() + c.getBlue());
        // int hasil = col * 10;
        // if (hasil > 255) {
        // hasil = 255;
        // } else if (hasil < 0) {
        // hasil = 0;
        // }
        // Color newColor = new Color(hasil, hasil, hasil);
        // image.setRGB(j, i, newColor.getRGB());
        // }
        // }
        // File output_file = new File("D:\\gbr\\skalar_kali.jpg");
        // ImageIO.write(image, "jpg", output_file);
        // System.out.println("Writing complete.");
        // }

        // catch (IOException e) {
        // System.out.println("Error: " + e);
        // }

        // skalar bagi
//        try {
//            for (int i = 0; i < height; i++) {
//                for (int j = 0; j < width; j++) {
//                    Color c = new Color(image.getRGB(j, i));
//                    int col = (int) (c.getRed() + c.getGreen() + c.getBlue());
//                    int hasil = col / 10;
//                    if (hasil > 255) {
//                        hasil = 255;
//                    } else if (hasil < 0) {
//                        hasil = 0;
//                    }
//                    Color newColor = new Color(hasil, hasil, hasil);
//                    image.setRGB(j, i, newColor.getRGB());
//                }
//            }
//            File output_file = new File("D:\\gbr\\aritmatik.jpg");
//            ImageIO.write(image, "jpg", output_file);
//            System.out.println("Writing complete.");
//        }
//
//        catch (IOException e) {
//            System.out.println("Error: " + e);
        }
    }

