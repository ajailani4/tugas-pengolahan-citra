package main;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class Aritmatika {
    static BufferedImage image = null;

    public static void main(String[] args) {
        penjumlahan();
        pengurangan();
        perkalian();
        skalarTambah();
        skalarKurang();
        skalarKali();
        skalarBagi();
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

    private static void penjumlahan() {
        try {
            readImage("2018");

            int width = image.getWidth();
            int height = image.getHeight();

            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    Color c = new Color(image.getRGB(j, i));
                    Color c1 = new Color(image.getRGB(j, i));
                    int col = c.getRed() + c.getGreen() + c.getBlue();
                    int col1 = c1.getRed() + c1.getGreen() + c1.getBlue();
                    int hasil = (col + col1) / 2;

                    if (hasil > 255) {
                        hasil = 255;
                    } else if (hasil < 0) {
                        hasil = 0;
                    } else {
                        hasil = hasil;
                    }
                    Color newColor = new Color(hasil, hasil, hasil);
                    image.setRGB(j, i, newColor.getRGB());
                }
            }

            writeImage(image, "aritmatika_gbr1");
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }

    private static void pengurangan() {
        try {
            readImage("16004");

            int width = image.getWidth();
            int height = image.getHeight();

            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    Color c = new Color(image.getRGB(j, i));
                    Color c1 = new Color(image.getRGB(j, i));
                    int col = c.getRed() + c.getGreen() + c.getBlue();
                    int col1 = c1.getRed() + c1.getGreen() + c1.getBlue();
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

            writeImage(image, "aritmatika_gbr2");
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }

    private static void perkalian() {
        try {
            readImage("23084");

            int width = image.getWidth();
            int height = image.getHeight();

            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    Color c = new Color(image.getRGB(j, i));
                    Color c1 = new Color(image.getRGB(j, i));
                    int col = c.getRed() + c.getGreen() + c.getBlue();
                    int col1 = c1.getRed() + c1.getGreen() + c1.getBlue();
                    int hasil = col * col1;
                    if (hasil > 255) {
                        hasil = 255;
                    } else if (hasil < 0) {
                        hasil = 0;
                    }
                    Color newColor = new Color(hasil, hasil, hasil);
                    image.setRGB(j, i, newColor.getRGB());
                }
            }

            writeImage(image, "aritmatika_gbr3");
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }

    private static void skalarTambah() {
        try {
            readImage("24063");

            int width = image.getWidth();
            int height = image.getHeight();

            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    Color c = new Color(image.getRGB(j, i));
                    int col = c.getRed() + c.getGreen() + c.getBlue();
                    int hasil = col + 100;
                    if (hasil > 255) {
                        hasil = 255;
                    } else if (hasil < 0) {
                        hasil = 0;
                    }
                    Color newColor = new Color(hasil, hasil, hasil);
                    image.setRGB(j, i, newColor.getRGB());
                }
            }

            writeImage(image, "aritmatika_gbr4");
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }

    private static void skalarKurang() {
        try {
            readImage("41004");

            int width = image.getWidth();
            int height = image.getHeight();

            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    Color c = new Color(image.getRGB(j, i));
                    int col = c.getRed() + c.getGreen() + c.getBlue();
                    int hasil = col - 100;
                    if (hasil > 255) {
                        hasil = 255;
                    } else if (hasil < 0) {
                        hasil = 0;
                    }
                    Color newColor = new Color(hasil, hasil, hasil);
                    image.setRGB(j, i, newColor.getRGB());
                }
            }

            writeImage(image, "aritmatika_gbr5");
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }

    private static void skalarKali() {
        try {
            readImage("41025");

            int width = image.getWidth();
            int height = image.getHeight();

            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    Color c = new Color(image.getRGB(j, i));
                    int col = c.getRed() + c.getGreen() + c.getBlue();
                    int hasil = col * 10;
                    if (hasil > 255) {
                        hasil = 255;
                    } else if (hasil < 0) {
                        hasil = 0;
                    }
                    Color newColor = new Color(hasil, hasil, hasil);
                    image.setRGB(j, i, newColor.getRGB());
                }
            }

            writeImage(image, "aritmatika_gbr6");
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }

    private static void skalarBagi() {
        try {
            readImage("46076");

            int width = image.getWidth();
            int height = image.getHeight();

            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    Color c = new Color(image.getRGB(j, i));
                    int col = c.getRed() + c.getGreen() + c.getBlue();
                    int hasil = col / 10;
                    if (hasil > 255) {
                        hasil = 255;
                    } else if (hasil < 0) {
                        hasil = 0;
                    }
                    Color newColor = new Color(hasil, hasil, hasil);
                    image.setRGB(j, i, newColor.getRGB());
                }
            }

            writeImage(image, "aritmatika_gbr7");
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }
}
