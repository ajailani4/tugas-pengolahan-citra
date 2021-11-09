package tugaspengcit;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;

public class Geometri {
    static BufferedImage image = null;

    public static void main(String[] args) {
        readImage();
        translation(image, 15, 10);
        writeImage(image, "geometri_gbr1");
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

    private static void translation(BufferedImage image, int m, int n) {
        int width = image.getWidth();
        int height = image.getHeight();
        int[][] imagePixel = getPixelArray(image);
        int[][] result = new int[height][width];

        // Translate pixel array
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
}
