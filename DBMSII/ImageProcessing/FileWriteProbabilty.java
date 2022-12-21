package ImageProcessing;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileWriteProbabilty {
    public void writeProbability(Probability probability){
        try{
            File file = new File("I:\\5th semester\\DBMS2\\ibtd\\probability.txt");
            FileWriter fileWriter = new FileWriter(file);
            for(int i=0;i< 256;i++){
                for (int j=0;j< 256;j++){
                    for (int k=0;k< 256;k++){
                        fileWriter.write(probability.probabiityArray[i][j][k] + " ");
                    }
                }
            }
            fileWriter.close();
        }
        catch (IOException exception){
            System.out.println("error" + exception);
        }
        catch (Exception exception){
            System.out.println("error" + exception);
        }
    }
}
