package SkinDetection;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.Scanner;

public class TestRestRandom {

    public static void main(String[] args) throws IOException {
        File nameFile= new File("I:\\5th semester\\DBMS2\\ibtd\\ibtbcountoutput\\TestFileName.txt");
        File readFile= new File("I:\\5th semester\\DBMS2\\ibtd\\ibtbcountoutput\\RandomImageOutput.txt");
        FileReader fileReader = new FileReader(readFile);
        BufferedReader Buffer= new BufferedReader(fileReader);

        Scanner sc = new Scanner(nameFile);
        String[] FileNameString = new String[100];
        File[] file= new File[100];
        int i=0,j =0, k=0;
        double[][][] prob=new double[256][256][256];
        double T=0.4;

        for(i=0;i<256;i++){
            for(j=0;j<256;j++){
                for(k=0;k<256;k++){
                    prob[i][j][k]=Double.parseDouble(Buffer.readLine());
                }
            }
        }
        fileReader.close();

        i=0;
        while(sc.hasNextLine()){
            FileNameString[i] = sc.nextLine();
            file[i] = new File(FileNameString[i]);
            i++;
        }

        for(int f=0;f<file.length-1;f++){
            BufferedImage Image = ImageIO.read(file[f]);

            File newFile= new File("I:\\5th semester\\DBMS2\\ibtd\\ibtbcountoutput\\RandomTest\\"+f+".jpg");

            for(i=0;i<Image.getHeight();i++){
                for(j=0;j< Image.getWidth();j++){
                    int pixel = Image.getRGB(j,i);
                    //Creating a Color object from pixel value
                    Color color = new Color(pixel, true);
                    //Retrieving the R G B values
                    int red = color.getRed();
                    int green = color.getGreen();
                    int blue = color.getBlue();

                    if(prob[red][green][blue]<=T){
                        red=255;
                        green=255;
                        blue=255;
                    }
                    else{
                        System.out.println("Red: "+red+" Green: "+green+" Blue: "+blue);
                    }
                    color = new Color(red, green, blue);
                    Image.setRGB(j, i, color.getRGB());
                }
            }

            ImageIO.write(Image,"jpg", newFile);
            System.out.println("Done....");
        }

    }

}
