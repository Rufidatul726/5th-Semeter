import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;

public class TestingImage {

        public static void main(String[] args) throws IOException {
            File TestImage= new File("E:\\5th-Semeter\\DBMSII\\ibtd\\NonMask\\0147.jpg");
            BufferedImage image= ImageIO.read(TestImage);

            File OutputImage= new File("E:\\5th-Semeter\\DBMSII\\New2.bmp");

            File fileRead= new File("E:\\5th-Semeter\\DBMSII\\New2.txt");

            double[][][] prob=new double[256][256][256];
            double T=0.4;

            FileReader fileReader = new FileReader(fileRead);
            BufferedReader Buffer= new BufferedReader(fileReader);

            int i=0,j=0,k=0;

            for(i=0;i<256;i++){
                for(j=0;j<256;j++){
                    for(k=0;k<256;k++){
                        prob[i][j][k]=Double.parseDouble(Buffer.readLine());
                    }
                }
            }

            for(i=0;i<image.getHeight();i++){
                for(j=0;j< image.getWidth();j++){
                    int pixel = image.getRGB(j,i);
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
                    color = new Color(red, green, blue);
                    image.setRGB(j, i, color.getRGB());
                }
            }

            fileReader.close();
            ImageIO.write(image,"jpg", OutputImage);
            System.out.println("Done....");
        }
}
