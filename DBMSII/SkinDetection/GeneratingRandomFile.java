package SkinDetection;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GeneratingRandomFile {
    public static void main(String[] args) throws IOException {

        String stringFolder ="I:\\5th semester\\DBMS2\\ibtd\\Mask";
        File folder = new File(stringFolder);
        File[] listOfFiles = folder.listFiles();

        int FolderSize = listOfFiles.length;

        int TrainingSize = (int) (FolderSize*0.9);
        int TestingSize= FolderSize-TrainingSize;

        List<Integer>TrainPicNumber=new ArrayList<Integer>();
        List<Integer>TestPicNumber=new ArrayList<Integer>();

        File newFile= new File("I:\\5th semester\\DBMS2\\ibtd\\ibtbcountoutput\\TestFileName.txt");
        FileWriter writer1 = new FileWriter(newFile);

        Random rand = new Random();
        int i=0;
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

        String[] FileNameString = new String[TrainingSize +1];
        File[] file= new File[TrainingSize +1];

        String[] FileNameString1 = new String[TrainingSize +1];
        File[] file1= new File[TrainingSize +1];

        for(i=0; i<TrainingSize; i++) {
            int RandomNumber= TrainPicNumber.get(i);

            FileNameString[i] = "I:\\5th semester\\DBMS2\\ibtd\\NonMask\\" + String.format("%04d", RandomNumber) + ".jpg";
            file[i] = new File(FileNameString[i]);

            FileNameString1[i] = "I:\\5th semester\\DBMS2\\ibtd\\Mask\\" + String.format("%04d", RandomNumber) + ".bmp";
            file1[i] = new File(FileNameString1[i]);

        }

        TrainingRandomFile trainingRandomFile = new TrainingRandomFile();
        trainingRandomFile.trainingRandomFile(file, file1, TrainingSize);

        String[] TestFiles = new String[TestingSize +1];

        for(i=0; i<TestingSize; i++) {
            int RandomNumber= TestPicNumber.get(i);

            TestFiles[i] = "I:\\5th semester\\DBMS2\\ibtd\\NonMask\\" + String.format("%04d", RandomNumber) + ".jpg";
            writer1.append(TestFiles[i] + "\n");
            writer1.flush();
        }
        writer1.close();
        System.out.println("Training Random File Done");

    }
}
