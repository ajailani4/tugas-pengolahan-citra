package main;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;

public class Gaussian {
    static BufferedImage image = null;

    public static void main(String[] args) {
        readImage("46076");
        image = apply(image, 7, 1.0);
        writeImage(image, "gaussian_gbr1");
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

    public static double[][] kernel(int _size, double sigma) {
        int size = _size;
        double[][] gaussian = new double[size][size];
        for (int j = 0; j < size; j++) {
            for (int i = 0; i < size; i++) {
                int xValue = i - (size / 2);
                int yValue = j - (size / 2);
                gaussian[i][j] = (1 / (2 * Math.PI * Math.pow(sigma, 2))) * (Math.pow(Math.E, -((Math.pow(xValue, 2) + Math.pow(yValue, 2)) / (2 * Math.pow(sigma, 2)))));

            }
        }

        return gaussian;
    }

    public static double kernel_sum(double[][] kernel) {
        double kernel_sum = 0.0;
        for (int i = 0; i < kernel.length; i++) {
            for (int j = 0; j < kernel.length; j++) {
                kernel_sum += kernel[i][j];
            }
        }
        return kernel_sum;
    }

    public static BufferedImage apply(BufferedImage _image, int size, double sigma) {

        BufferedImage imageOutput = new BufferedImage(_image.getWidth(), _image.getHeight(), BufferedImage.TYPE_3BYTE_BGR);   // Set initial BufferedImage

        double[][] gaussian = Gaussian.kernel(size, sigma);
        double agv = Gaussian.kernel_sum(gaussian);
        int wight = _image.getWidth();
        int heigth = _image.getHeight();
        int kernelSize = gaussian.length;
        int kernelXY = kernelSize / 2;

        for (int i = 0; i < wight; i++) {
            for (int j = 0; j < heigth; j++) {
                int r = 0, g = 0, b = 0;

                for (int k = -kernelXY; k <= kernelXY; k++) {
                    for (int l = -kernelXY; l <= kernelXY; l++) {
                        if (k * k + l * l < gaussian.length * gaussian.length) {
                            int p = getRGBW(_image, i + k, j + l);
                            r += ((p >> 16) & 0xFF) * gaussian[k + kernelXY][l + kernelXY];
                            g += ((p >> 8) & 0xFF) * gaussian[k + kernelXY][l + kernelXY];
                            b += (p & 0xFF) * gaussian[k + kernelXY][l + kernelXY];
                        }
                    }
                }
                int rgb = ((int) (r / agv) << 16) | ((int) (g / agv) << 8) | ((int) (b / agv));

                imageOutput.setRGB(i, j, rgb);
            }
        }

        return imageOutput;
    }

    public static int getRGBW(BufferedImage image, int i, int j) {
        int width = image.getWidth();
        int height = image.getHeight();
        i = Math.max(0, Math.min(width - 1, i));
        j = Math.max(0, Math.min(height - 1, j));
        return image.getRGB(i, j);
    }
}
