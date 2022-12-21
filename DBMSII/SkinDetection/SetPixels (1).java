import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.awt.Color;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

public class SetPixels {
    public static void main(String args[])throws IOException {
        int i=0, j=0, k=0;
        double[][][] skin = new double[256][256][256];
        double[][][] nonskin =new double[256][256][256];
        double skincol=0, skinnocol=0;
        double t=0.000;
        double[][][] prob=new double[256][256][256];
        String nonMaskFolder="E:\\5th-Semeter\\DBMSII\\ibtd\\NonMask";
        String maskFolder="E:\\5th-Semeter\\DBMSII\\ibtd\\Mask";

        for(i=0;i<256;i++){
            for(j=0;j<256;j++){
                for(k=0;k<256;k++){
                    skin[i][j][k]=0.00;
                    nonskin[i][j][k]=0.00;
                }
            }
        }


        //Reading the image
        File file= new File(maskFolder);
        File[] files= file.listFiles();

        File file1= new File(nonMaskFolder);
        File[] files1= file1.listFiles();

        //ileWriter writer = new FileWriter("E:\\5th-Semeter\\DBMSII\\New.txt");
        FileWriter writer1 = new FileWriter("E:\\5th-Semeter\\DBMSII\\New2.txt");

        for(int f=0;f< files.length; f++){

            BufferedImage img = ImageIO.read(files[f]);
            BufferedImage img1 = ImageIO.read(files1[f]);
            for (int y = 0; y < img.getHeight() && y < img1.getHeight(); y++) {
                for (int x = 0; x < img.getWidth() && x < img1.getWidth(); x++) {
                    //Retrieving contents of a pixel
                    int pixel = img.getRGB(x,y);
                    //Creating a Color object from pixel value
                    Color color = new Color(pixel, true);
                    //Retrieving the R G B values
                    int red = color.getRed();
                    int green = color.getGreen();
                    int blue = color.getBlue();

                    int red2, green2, blue2;

                    int pixel1 = img1.getRGB(x,y);
                    Color color1 = new Color(pixel1, true);

                    int red1 = color1.getRed();
                    int green1 = color1.getGreen();
                    int blue1 = color1.getBlue();


                    if(red>240 && green>240 && blue>240){
                        nonskin[red1][green1][blue1]++;
                        skinnocol += 1;
//
//                        red2=red1;
//                        green2=green1;
//                        blue2=blue1;
                    }
                    else {
                        skin[red1][green1][blue1]++;
                        skincol += 1;
//
//                        red2=red;
//                        green2=green;
//                        blue2=blue;

                    }

                    //color = new Color(red2, green2, blue2);

                    //img.setRGB(x, y, color.getRGB());

                }
            }
        }

        for(i=0; i<256; i++){
            for(j=0;j<256;j++){
                for(k=0;k<256;k++){
                    if(nonskin[i][j][k]==0 || skin[i][j][k]==0){
                        prob[i][j][k]=0;
                    }
                    else{
                        skin[i][j][k]=skin[i][j][k]/skincol;
                        nonskin[i][j][k]= nonskin[i][j][k]/skinnocol;
                        prob[i][j][k]= skin[i][j][k]/nonskin[i][j][k];

                        System.out.println("Probability "+i+  " " +j+  " " +k+  " "+ prob[i][j][k]);
                    }

                    writer1.append(prob[i][j][k]+"\n");

                    writer1.flush();
                }
            }
        }

        writer1.close();
        //Saving the modified image
        //file = new File("E:\\5th-Semeter\\DBMSII\\New2.bmp");
       // ImageIO.write(img, "jpg", file);
        System.out.println("Done...");
    }
}