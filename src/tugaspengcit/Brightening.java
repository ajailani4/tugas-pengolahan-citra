package tugaspengcit;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import java.io.IOException;

public class Brightening {
    public static void main(String[] args) throws IOException {
        int width = 321;
        int height = 481;
        BufferedImage image = null;
        try {
            File input_file = new File("D://gbr//2018.jpg");
            image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);

            image = ImageIO.read(input_file);
            System.out.println("Reading complete.");
        }

        catch (IOException e) {
            System.out.println("Error: " + e);
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

        try {
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
            File output_file = new File("D://gbr//brightening.jpg");
            ImageIO.write(image, "jpg", output_file);
            System.out.println("Writing complete.");
        }

        catch (IOException e) {
            System.out.println("Error: " + e);
        }
    }
}
