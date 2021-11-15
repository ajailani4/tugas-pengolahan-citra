package main;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;

public class Geometri {
    static BufferedImage image = null;

    public static void main(String[] args) {
        readImage();
//        translate(image, 15, 10);
//        flip(image, "horizontal");
//        scale(image, 2, 2);
        writeImage(image, "geometri_gbr5");
    }

    private static void readImage() {
        try {
            File inputFile = new File("C:\\Users\\ahmad\\IdeaProjects\\TugasPengCit\\src\\assets\\Prince_Zuko.jpg");
            image = ImageIO.read(inputFile);

            System.out.println("Reading complete");
        } catch(Exception e) {
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

    private static int[][] getPixelArray(BufferedImage image) {
        int width = image.getWidth();
        int height = image.getHeight();
        int[][] result = new int[height][width];

        for (int i=0;i<height;i++) {
            for(int j=0;j<width;j++) {
                result[i][j] = image.getRGB(j, i);
            }
        }

        return result;
    }

    private static void translate(BufferedImage image, int m, int n) {
        int width = image.getWidth();
        int height = image.getHeight();
        int[][] imagePixel = getPixelArray(image);
        int[][] result = new int[height][width];

        for (int i=0;i<height;i++) {
            if (i == height-n-1) break;

            for (int j=0;j<width;j++) {
                if (j == width-m-1) break;

                result[i][j] = imagePixel[i+n][j+m];
            }
        }

        for (int i=0;i<height;i++) {
            for (int j=0;j<width;j++) {
                image.setRGB(j, i, result[i][j]);
            }
        }
    }

    private static void flip(BufferedImage image, String mode) {
        int width = image.getWidth();
        int height = image.getHeight();
        int[][] imagePixel = getPixelArray(image);
        int[][] result = new int[height][width];

        switch (mode.toLowerCase()) {
            case "vertical":
                for (int i=0;i<height;i++) {
                    for (int j=0;j<width;j++) {
                        result[i][j] = imagePixel[(height-1) - i][j];
                    }
                }

                break;

            case "horizontal":
                for (int i=0;i<height;i++) {
                    for (int j=0;j<width;j++) {
                        result[i][j] = imagePixel[i][(width-1) - j];
                    }
                }

                break;

            case "origin":
                for (int i=0;i<height;i++) {
                    for (int j=0;j<width;j++) {
                        result[i][j] = imagePixel[(height-1) - i][(width-1) - j];
                    }
                }

                break;
        }

        for (int i=0;i<height;i++) {
            for (int j=0;j<width;j++) {
                image.setRGB(j, i, result[i][j]);
            }
        }
    }

    private static void scale(BufferedImage image, int sX, int sY) {
        int width = image.getWidth();
        int height = image.getHeight();
        int[][] imagePixel = getPixelArray(image);
        int sWidth = width * sY;
        int sHeight = height * sX;
        int[][] result = new int[sHeight][sWidth];
        int m = 0, n = 0;

        for (int i=0;i<height;i++) {
            for (int j=0;j<width;j++) {
                result[m][n] = imagePixel[i][j];
                result[m][n+1] = imagePixel[i][j];
                result[m+1][n] = imagePixel[i][j];
                result[m+1][n+1] = imagePixel[i][j];

                n += sY;
            }

            m += sX;
            n = 0;
        }

        for (int i=0;i<height;i++) {
            for (int j=0;j<width;j++) {
                image.setRGB(j, i, result[i][j]);
            }
        }
    }
}
