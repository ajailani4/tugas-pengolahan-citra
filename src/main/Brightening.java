package main;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import java.io.IOException;

public class Brightening {
     static BufferedImage image = null;
    
     public static void main(String[]args){
        brightening();
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
            File outputFile = new File(""C:\\Users\\ahmad\\IdeaProjects\\TugasPengCit\\src\\output\\" + fileName + ".jpg");
            ImageIO.write(image, "jpg", outputFile);
            System.out.println("Writing complete");
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }
   
        
//        rumus :
//        Pencerahan Citra (image brightening) 
// f(x,y)' = f(x,y)  + b
//         b = 100
                 
//• Kecerahan citra dapat diperbaiki dengan menambahkan/mengurangkan
//sebuah konstanta kepada (atau dari) setiap pixel. 
//• Jika b positif, kecerahan citra bertambah, 
//Jika b negatif kecerahan citra berkurang
//• Perlu operasi clipping jika nilai f(x,y)’ berada di bawah nilai intensitas
//minimum atau d atas nilai intensitas maksimum:

       private static void brightening(){
        
 
//        rumus :
//        Pencerahan Citra (image brightening) 
// f(x,y)' = f(x,y)  + b
//         b = 100
                 
//• Kecerahan citra dapat diperbaiki dengan menambahkan/mengurangkan
//sebuah konstanta kepada (atau dari) setiap pixel. 
//• Jika b positif, kecerahan citra bertambah, 
//Jika b negatif kecerahan citra berkurang
//• Perlu operasi clipping jika nilai f(x,y)’ berada di bawah nilai intensitas
//minimum atau d atas nilai intensitas maksimum:

        try {
            readImage("2018");

            int width = image.getWidth();
            int height = image.getHeight();
            
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    Color c = new Color(image.getRGB(j, i));
                    int col = (int) ((c.getRed() + c.getGreen() + c.getBlue())/3 );
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
            
            writeImage(image, "aritmatika_gbr1");
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }
}
