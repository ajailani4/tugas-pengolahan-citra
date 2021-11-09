package tugaspengcit;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import java.io.IOException;

public class Thresholding {
    public static void main(String[] args) throws IOException {
        int width = 1600;
        int height = 1200;
        BufferedImage image = null;
        try {
            File input_file = new File("D:\\gbr\\gg.jpeg");
            image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);

            image = ImageIO.read(input_file);
            System.out.println("Reading complete.");
        }

        catch (IOException e) {
            System.out.println("Error: " + e);
        }
                
        try {
            int thresholdValue=127;
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    Color c = new Color(image.getRGB(j, i));
                    int col = (int) (((c.getRed()) + c.getBlue()) + (c.getGreen())/3);
                    Color newColor = new Color(255,255,255);
                    Color newColor2 = new Color(0,0,0);
                    if(thresholdValue>col){
                        image.setRGB(j, i, newColor.getRGB());
                    }
                    else{
                        image.setRGB(j, i, newColor2.getRGB());
                    }
                    
                }
            }
            File output_file = new File("D:\\gbr\\gg_threshold_Avrg.jpeg");
            ImageIO.write(image, "jpeg", output_file);
            System.out.println("Writing complete.");
        }
        catch (IOException e) {
            System.out.println("Error: " + e);
        }
////Auto_Thresholding     
//        try {
//            int thresholdValue=127;
//            int iThreshold;
//            int sum1,sum2,count1,count2;
//            int mean1,mean2;
//            //search thresholding
//            while(true){
//                sum1=sum2=count1=count2=0;
//                for (int i = 0; i < height; i++) {
//                    for (int j = 0; j < width; j++) {
//                        Color c = new Color(image.getRGB(j, i));
//                        int rataRataRGB = (int) (((c.getRed()) + c.getBlue()) + (c.getGreen()))/3;
//                        
//                        if(rataRataRGB< thresholdValue){
//                            sum1 += rataRataRGB;
//                            count1++;
//                        }
//                        else{
//                             sum2 += rataRataRGB;
//                            count2++;
//                        }
//
//                    }
//                }
//                //calculacing mean
//                mean1 = (count1 > 0)?(int)(sum1/count1):0;
//                mean2 = (count2 > 0)?(int)(sum2/count2):0;
//                
//                //calculacing intermediate threshold
//                iThreshold = (mean1 + mean2)/2;
//                
//                if(thresholdValue!=iThreshold){
//                    thresholdValue = iThreshold;
//                }else{
//                    break;
//                }
//            }
//            //performing threshiolding on the iamge pixels
//            for (int i = 0; i < height; i++) {
//                for (int j = 0; j < width; j++) {
//                    Color c = new Color(image.getRGB(j, i));
//                    
//                    int rataRataRGB = (int) (((c.getRed()) + c.getBlue()) + (c.getGreen()))/3;
//                    Color newColor = new Color(255,255,255,255);
//                    Color newColor2 = new Color(255,0,0,0);
//                    
//                    if(thresholdValue > rataRataRGB ){
//                        image.setRGB(j, i, newColor.getRGB());
//                    }
//                    else{
//                        image.setRGB(j, i, newColor2.getRGB());
//                    }
//                    
//                }
//                File output_file = new File("D:\\gbr\\threshold_Auto.jpg");
//                ImageIO.write(image, "jpg", output_file);
//                System.out.println("Writing complete.");
//            }
//        }
//        catch (IOException e) {
//        System.out.println("Error: " + e);    
//        }
 
// To Binnary

     try {
            int thresholdValue=127;
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    Color c = new Color(image.getRGB(j, i));
                    int col = (int) (((0.2126*c.getRed()) + 0.0722*c.getBlue()) + (0.7152*c.getGreen()));
                    Color newColor = new Color(255,255,255,255);
                    Color newColor2 = new Color(0,0,0,0);
                    if(col>=thresholdValue){
                        image.setRGB(j, i, newColor.getRGB());
                    }
                    else{
                        image.setRGB(j, i, newColor2.getRGB());
                    }
                    
                }
            }
            File output_file = new File("D:\\gbr\\threshold_Binnary.jpg");
            ImageIO.write(image, "jpg", output_file);
            System.out.println("Writing complete.");
        }
        catch (IOException e) {
            System.out.println("Error: " + e);
        }    
////Auto_ThresholdingRedValue    
//         try {
//            int thresholdValue=127;
//            int iThreshold;
//            int sum1,sum2,count1,count2;
//            int mean1,mean2;
//            //search thresholding
//            while(true){
//                sum1=sum2=count1=count2=0;
//                for (int i = 0; i < height; i++) {
//                    for (int j = 0; j < width; j++) {
//                        Color c = new Color(image.getRGB(j, i));
//                        int r = c.getRed();
//                        if(r < thresholdValue){
//                            sum1+=r;
//                            count1++;
//                        }
//                        else{
//                             sum2+=r;
//                            count2++;
//                        }
//
//                    }
//                }
//                //calculacing mean
//                mean1 = (count1 > 0)?(int)(sum1/count1):0;
//                mean2 = (count2 > 0)?(int)(sum2/count2):0;
//                
//                //calculacing intermediate treshold
//                iThreshold = (mean1 + mean2)/2;
//                
//                if(thresholdValue!=iThreshold){
//                    thresholdValue = iThreshold;
//                }else{
//                    break;
//                }
//            }
//            //performing threshiolding on the iamge pixels
//            for (int i = 0; i < height; i++) {
//                for (int j = 0; j < width; j++) {
//                    Color c = new Color(image.getRGB(j, i));
//                    int r = c.getRed();
//                    Color newColor = new Color(255,255,255,255);
//                    Color newColor2 = new Color(255,0,0,0);
//                    if(thresholdValue > r ){
//                        image.setRGB(j, i, newColor.getRGB());
//                    }
//                    else{
//                        image.setRGB(j, i, newColor2.getRGB());
//                    }
//                    
//                }
//                File output_file = new File("D:\\gbr\\threshold_AutoRedValue.jpg");
//                ImageIO.write(image, "jpg", output_file);
//                System.out.println("Writing complete.");
//            }
//        }
//        catch (IOException e) {
//        System.out.println("Error: " + e);    
//        }
//        
////Auto_ThresholdGreen
//   
//         try {
//            int thresholdValue=127;
//            int iThreshold;
//            int sum1,sum2,count1,count2;
//            int mean1,mean2;
//            //search thresholding
//            while(true){
//                sum1=sum2=count1=count2=0;
//                for (int i = 0; i < height; i++) {
//                    for (int j = 0; j < width; j++) {
//                        Color c = new Color(image.getRGB(j, i));
//                        int g = c.getGreen();
//                        if(g < thresholdValue){
//                            sum1+=g;
//                            count1++;
//                        }
//                        else{
//                             sum2+=g;
//                            count2++;
//                        }
//
//                    }
//                }
//                //calculacing mean
//                mean1 = (count1 > 0)?(int)(sum1/count1):0;
//                mean2 = (count2 > 0)?(int)(sum2/count2):0;
//                
//                //calculacing intermediate treshold
//                iThreshold = (mean1 + mean2)/2;
//                
//                if(thresholdValue!=iThreshold){
//                    thresholdValue = iThreshold;
//                }else{
//                    break;
//                }
//            }
//            //performing threshiolding on the iamge pixels
//            for (int i = 0; i < height; i++) {
//                for (int j = 0; j < width; j++) {
//                    Color c = new Color(image.getRGB(j, i));
//                    int g = c.getGreen();
//                    Color newColor = new Color(255,255,255,255);
//                    Color newColor2 = new Color(255,0,0,0);
//                    if(thresholdValue > g ){
//                        image.setRGB(j, i, newColor.getRGB());
//                    }
//                    else{
//                        image.setRGB(j, i, newColor2.getRGB());
//                    }
//                    
//                }
//                File output_file = new File("D:\\gbr\\threshold_AutoGreenValue.jpg");
//                ImageIO.write(image, "jpg", output_file);
//                System.out.println("Writing complete.");
//            }
//        }
//        catch (IOException e) {
//        System.out.println("Error: " + e);    
//        }
    }
}
