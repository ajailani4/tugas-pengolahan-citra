/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import java.io.IOException;
/**
 *
 * @author Chaca Annisa
 */
public class Sobel {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        int width = 321;
        int height = 481;
        BufferedImage image = null;
        int[][] pixelMatrix=new int[3][3];
        try {
            File input_file = new File("D:\\gbr\\2018.jpg");
            image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);

            image = ImageIO.read(input_file);
            System.out.println("Reading complete.");
        }

        catch (IOException e) {
            System.out.println("Error: " + e);
        }
        try {

        for(int i=1;i<width-1;i++){
            for(int j=1;j<height-1;j++){
                
                pixelMatrix[0][0]=new Color(image.getRGB(i-1,j-1)).getRed();
                pixelMatrix[0][1]=new Color(image.getRGB(i-1,j)).getRed();
                pixelMatrix[0][2]=new Color(image.getRGB(i-1,j+1)).getRed();
                pixelMatrix[1][0]=new Color(image.getRGB(i,j-1)).getRed();
                pixelMatrix[1][2]=new Color(image.getRGB(i,j+1)).getRed();
                pixelMatrix[2][0]=new Color(image.getRGB(i+1,j-1)).getRed();
                pixelMatrix[2][1]=new Color(image.getRGB(i+1,j)).getRed();
                pixelMatrix[2][2]=new Color(image.getRGB(i+1,j+1)).getRed();

                int edge=(int) convolution(pixelMatrix);
                image.setRGB(i,j,(edge<<16 | edge<<8 | edge));
            }
        }
         File output_file = new File("D:\\gbr\\sobel.jpg");
            ImageIO.write(image, "jpg", output_file);
            System.out.println("Writing complete.");
        }

        catch (IOException e) {
            System.out.println("Error: " + e);
    }
        
    
}
    public static double convolution(int[][] pixelMatrix){

    int gy=(pixelMatrix[0][0]*-1)+(pixelMatrix[0][1]*-2)+(pixelMatrix[0][2]*-1)+(pixelMatrix[2][0])+(pixelMatrix[2][1]*2)+(pixelMatrix[2][2]*1);
    int gx=(pixelMatrix[0][0])+(pixelMatrix[0][2]*-1)+(pixelMatrix[1][0]*2)+(pixelMatrix[1][2]*-2)+(pixelMatrix[2][0])+(pixelMatrix[2][2]*-1);
    return Math.sqrt(Math.pow(gy,2)+Math.pow(gx,2));

}
}