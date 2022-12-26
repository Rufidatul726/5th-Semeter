package SkinDetection;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class TrainingRandomFile {
    public void trainingRandomFile(File[] OriginFile, File[] MaskFile, int Size) throws IOException {
        int i=0, j=0, k=0;
        double[][][] skin = new double[256][256][256];
        double[][][] nonskin =new double[256][256][256];
        double skincol=0, skinnocol=0;
        double t=0.000;
        double[][][] prob=new double[256][256][256];

        File file= new File("I:\\5th semester\\DBMS2\\ibtd\\ibtbcountoutput\\RandomImageOutput.txt");
        FileWriter writer1 = new FileWriter(file);

        for(i=0;i<256;i++){
            for(j=0;j<256;j++){
                for(k=0;k<256;k++){
                    skin[i][j][k]=0.00;
                    nonskin[i][j][k]=0.00;
                }
            }
        }

        for(int f=0;f<Size;f++){
            BufferedImage img = ImageIO.read(MaskFile[f]);

            BufferedImage img1 = ImageIO.read(OriginFile[f]);
            //System.out.println(f+ "no file : Training original File: "+OriginFile[f].getName());

            for (int y = 0; y < img.getHeight() && y < img1.getHeight(); y++) {
                for (int x = 0; x < img.getWidth() && x < img1.getWidth(); x++) {
                    //Retrieving contents of a pixel
                    int pixel = img.getRGB(x,y);
                    Color color = new Color(pixel, true);

                    int red = color.getRed();
                    int green = color.getGreen();
                    int blue = color.getBlue();

                    int pixel1 = img1.getRGB(x,y);
                    Color color1 = new Color(pixel1, true);

                    int red1 = color1.getRed();
                    int green1 = color1.getGreen();
                    int blue1 = color1.getBlue();

                    if(red1>=240 && green1>=240 && blue1>=240){
                        skin[red][green][blue]++;
                        skincol++;
                    }
                    else{
                        nonskin[red][green][blue]++;
                        skinnocol++;
                    }
                }
            }
        }

        for(i=0;i<256;i++){
            for(j=0;j<256;j++){
                for(k=0;k<256;k++){
                    if(nonskin[i][j][k]==0){
                        prob[i][j][k]=0.000;
                    }
                    else{
                        skin[i][j][k]=skin[i][j][k]/skincol;
                        nonskin[i][j][k]=nonskin[i][j][k]/skinnocol;
                        prob[i][j][k]=skin[i][j][k]/nonskin[i][j][k];
                    }

                    writer1.append(prob[i][j][k]+"\n");

                    writer1.flush();
                }
            }
        }

        writer1.close();
        System.out.println("Done...");
    }
}
