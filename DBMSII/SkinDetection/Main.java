package SkinDetection;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
public class Main {

    public static void main(String[] args) throws IOException {
        File folder = new File("I:\\5th semester\\DBMS2\\ibtd\\NonMask");
        File[] listOfFiles = folder.listFiles();

        int FolderSize = listOfFiles.length;
        int TrainingSize = (int) (FolderSize*0.9);
        int TestingSize= FolderSize-TrainingSize;

       // File TrainingFolderMask;
        File[] TrainingFileMask= new File[TrainingSize+1];
        File[] TrainingFileUnmask= new File[TrainingSize+1];
        File[] TestingFileMask= new  File[TestingSize+1];
        File[] TestingFileUnmask= new File[TestingSize+1];

        List<Integer>TrainPicNumber=new ArrayList<Integer>();
        List<Integer> TestPicNumber=new ArrayList<Integer>();

        Random rand = new Random();
        int i=0, j=0, k=0;
        while(i<TrainingSize){
            int n = rand.nextInt(FolderSize);
            if(!TrainPicNumber.contains(n)){
                TrainPicNumber.add(n);
                i++;
            }
        }

        for(i=0;i<FolderSize;i++){
            if(!TrainPicNumber.contains(i)){
                TestPicNumber.add(i);
            }
        }

        for(i=0;i<TrainingSize;i++){
            TrainingFileUnmask[i]=new File("I:\\5th semester\\DBMS2\\ibtd\\NonMask\\"+ String.format("%04d" , TrainPicNumber.get(i))+ ".jpg");

            TrainingFileMask[i]=new File("I:\\5th semester\\DBMS2\\ibtd\\Mask\\"+ String.format("%04d" , TrainPicNumber.get(i))+ ".bmp");

        }

        File file= new File("I:\\5th semester\\DBMS2\\ibtd\\ibtbcountoutput\\RandomImageOutput.txt");
        FileWriter writer= new FileWriter(file);

        int skin=0, nonskin=0;
        double[][][] SkinArray=new double[256][256][256];
        double[][][] NonSkinArray= new double[256][256][256];
        double T=0.4;
        double prob=0.000;
        double[][][] Probability= new double[256][256][256];

        for(int f=0;f<TrainingSize;f++){
            BufferedImage MaskImage= ImageIO.read(TrainingFileMask[f]);
            BufferedImage UnmaskImage= ImageIO.read(TrainingFileUnmask[f]);

            for(i=0;i<MaskImage.getHeight() && i<UnmaskImage.getHeight();i++){
                for(j=0;j<MaskImage.getWidth() && j<UnmaskImage.getWidth();j++){
                    int pixel = MaskImage.getRGB(j,i);
                    int pixelUnmask = UnmaskImage.getRGB(j,i);
                    //Creating a Color object from pixel value
                    Color color = new Color(pixel, true);
                    Color colorUnmask= new Color(pixelUnmask, true);
                    //Retrieving the R G B values
                    int red = color.getRed();
                    int green = color.getGreen();
                    int blue = color.getBlue();

                    int redunmask = colorUnmask.getRed();
                    int greenunmask = colorUnmask.getGreen();
                    int blueunmask = colorUnmask.getBlue();


                    if(red>240 && green>240 && blue>240){
                        NonSkinArray[redunmask][greenunmask][blueunmask]++;
                        nonskin+=1;
                    }
                    else{
                        SkinArray[redunmask][greenunmask][blueunmask]++;
                        skin+=1;
                    }
                    //if(SkinArray[red][green][blue]!=0.000 && NonSkinArray[red][green][blue]!=0.0000)
                    //System.out.println(SkinArray[red][green][blue] + " " + NonSkinArray[red][green][blue]);
                }
            }
        }

        //System.out.println(skin+" "+nonskin);

        for(i=0;i<256;i++){
            for(j=0;j<256;j++){
                for(k=0;k<256;k++){
                    if(NonSkinArray[i][j][k]==0.000 || SkinArray[i][j][k]==0.000){
                        prob=0.000;
                    }
                    else{
                        SkinArray[i][j][k]= SkinArray[i][j][k]/(double) skin;
                        NonSkinArray[i][j][k]=NonSkinArray[i][j][k]/(double) nonskin;
                        prob=SkinArray[i][j][k]/NonSkinArray[i][j][k];
                    }
                    writer.append(prob+"\n");
                    writer.flush();


                }
            }
        }

        writer.close();

        FileReader fileReader= new FileReader(file);
        BufferedReader Buffer= new BufferedReader(fileReader);
        double itr_accuracy=0.0;

        for(i=0;i<256;i++){
            for(j=0;j<256;j++){
                for(k=0;k<256;k++){
                    Probability[i][j][k]=Double.parseDouble(Buffer.readLine());
                }
            }
        }

        for(i=0;i<TestingSize;i++){
            TestingFileUnmask[i]=new File("I:\\5th semester\\DBMS2\\ibtd\\NonMask\\"+ String.format("%04d" , TestPicNumber.get(i))+ ".jpg");

            TestingFileMask[i]=new File("I:\\5th semester\\DBMS2\\ibtd\\Mask\\"+ String.format("%04d" , TestPicNumber.get(i))+ ".bmp");

        }

        int tp=0, tn=0, fp=0, fn=0;
        double accuracy=0.000;

        for(int f=0; f<TestingSize; f++){
            BufferedImage image=  ImageIO.read(TestingFileUnmask[f]);
            BufferedImage MaskImage= ImageIO.read(TestingFileMask[f]);
            File OutputImage= new File("I:\\5th semester\\DBMS2\\ibtd\\ibtbcountoutput\\RandomTest\\"+ f +".bmp");

            for(i=0;i<image.getHeight() & i<MaskImage.getHeight();i++){
                for(j=0;j< image.getWidth() && j<MaskImage.getWidth();j++){
                    int pixel = image.getRGB(j,i);
                    int maskPixel= MaskImage.getRGB(j,i);
                    //Creating a Color object from pixel value
                    Color color = new Color(pixel, true);
                    Color maskColor= new Color(maskPixel, true);
                    //Retrieving the R G B values
                    int red = color.getRed();
                    int green = color.getGreen();
                    int blue = color.getBlue();

                    int redMask= maskColor.getRed();
                    int greenMask= maskColor.getGreen();
                    int blueMask= maskColor.getBlue();

                    if(Probability[red][green][blue]<=T){
                        red=255;
                        green=255;
                        blue=255;

                        if(redMask>240 && greenMask>240 && blueMask>240)tp++;
                        else tn++;
                    }
                    else{
                        if(redMask>240 && greenMask>240 && blueMask>240)fn++;
                        else fp++;
                    }
                    color = new Color(red, green, blue);
                    image.setRGB(j, i, color.getRGB());


                }
            }
            fileReader.close();
            ImageIO.write(image,"jpg", OutputImage);
            itr_accuracy= (double) (tp+tn)*100/(tp+tn+fp+fn);
            tp=0;tn=0;fp=0;fn=0;
            System.out.println("Accuracy: "+itr_accuracy+"\n");
            System.out.println("Done....");
        }

    }
}