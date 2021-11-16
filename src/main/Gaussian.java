package main;

import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Gaussian {
    static BufferedImage image = null;

    public static void main(String[] args) {
        readImage();
        image = apply(image, 7, 0.84089642);
        writeImage(image, "gaussian_gbr1");
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

    public static double[][] kernel(int _size, double sigma) {
        int size = _size;
        double gaussian[][] = new double[size][size];
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

        int c = 0;

        double gaussian[][] = Gaussian.kernel(size, sigma);
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
                            int p = RGB.getRGBW(_image, i + k, j + l);
                            // calculate a RGB by chip bit
                            r += ((p >> 16) & 0xFF) * gaussian[k + kernelXY][l + kernelXY];
                            g += ((p >> 8) & 0xFF) * gaussian[k + kernelXY][l + kernelXY];
                            b += (p & 0xFF) * gaussian[k + kernelXY][l + kernelXY];
                        }
                    } //end l
                }//end k
                int rgb = ((int) (r / agv) << 16) | ((int) (g / agv) << 8) | ((int) (b / agv));
                //set RGB revert to image
                imageOutput.setRGB(i, j, rgb);
            }// end i
        } //end j;
        return imageOutput;
    }
}
