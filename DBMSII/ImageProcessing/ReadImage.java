package ImageProcessing;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ReadImage{
    public int[][][] imageArray= new int[256][256][256];
    public int imagesize;
    public File fileRead;

    public void readImage(File fileRead) throws IOException {
        try{
            BufferedImage img = ImageIO.read(fileRead);
            imagesize= img.getHeight() * img.getWidth();

            for(int i=0;i< img.getHeight();i++){
                for (int j=0;j< img.getWidth();j++){
                    int pixel = img.getRGB(j,i);
                    Color color = new Color(pixel,true);
                    int red = color.getRed();
                    int green = color.getGreen();
                    int blue = color.getBlue();

                    imageArray[red][green][blue]++;

                }
            }
        }
        catch (Exception exception){
            System.out.println("error" + exception);
        }


    }
}
