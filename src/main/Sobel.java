package main;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;

public class Sobel {
    static BufferedImage image = null;

    public static void main(String[] args) {
        sobel();
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

    private static void sobel() {
        try {
            readImage("100080");

            int width = image.getWidth();
            int height = image.getHeight();

            int[][] edgeColors = new int[width][height];
            int maxGradient = -1;

            for (int i = 1; i < width - 1; i++) {
                for (int j = 1; j < height - 1; j++) {

                    int val00 = getGrayScale(image.getRGB(i - 1, j - 1));
                    int val01 = getGrayScale(image.getRGB(i - 1, j));
                    int val02 = getGrayScale(image.getRGB(i - 1, j + 1));

                    int val10 = getGrayScale(image.getRGB(i, j - 1));
                    int val11 = getGrayScale(image.getRGB(i, j));
                    int val12 = getGrayScale(image.getRGB(i, j + 1));

                    int val20 = getGrayScale(image.getRGB(i + 1, j - 1));
                    int val21 = getGrayScale(image.getRGB(i + 1, j));
                    int val22 = getGrayScale(image.getRGB(i + 1, j + 1));

                    int gx = ((-1 * val00) + (0 * val01) + (1 * val02))
                        + ((-2 * val10) + (0 * val11) + (2 * val12))
                        + ((-1 * val20) + (0 * val21) + (1 * val22));

                    int gy = ((-1 * val00) + (-2 * val01) + (-1 * val02))
                        + ((0 * val10) + (0 * val11) + (0 * val12))
                        + ((1 * val20) + (2 * val21) + (1 * val22));

                    double gval = Math.sqrt((gx * gx) + (gy * gy));
                    int g = (int) gval;

                    if (maxGradient < g) {
                        maxGradient = g;
                    }

                    edgeColors[i][j] = g;
                }
            }

            double scale = 255.0 / maxGradient;

            for (int i = 1; i < width - 1; i++) {
                for (int j = 1; j < height - 1; j++) {
                    int edgeColor = edgeColors[i][j];
                    edgeColor = (int) (edgeColor * scale);
                    edgeColor = 0xff000000 | (edgeColor << 16) | (edgeColor << 8) | edgeColor;

                    image.setRGB(i, j, edgeColor);
                }
            }

            writeImage(image, "sobel_gbr1");
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }

    public static int getGrayScale(int rgb) {
        int r = (rgb >> 16) & 0xff;
        int g = (rgb >> 8) & 0xff;
        int b = (rgb) & 0xff;

        int gray = (int) (0.2126 * r + 0.7152 * g + 0.0722 * b);

        return gray;
    }
}