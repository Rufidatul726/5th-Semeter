package ImageProcessing;

import java.io.File;
import java.io.IOException;

public class Main2NotFinal {
    public static void main(String[] args) throws IOException {
        try {
            File fileRead = new File("I:\\5th semester\\DBMS2\\ibtd\\0000.jpg");
            ReadImage readImage = new ReadImage();
            readImage.readImage(fileRead);

            IdentifySkinNonskin identifySkinNonskin = new IdentifySkinNonskin();
            identifySkinNonskin.identifySkin(readImage.imageArray);

            Probability probability = new Probability();
            probability.calculateProbability(identifySkinNonskin);

            FileWriteProbabilty fileWriteProbabilty = new FileWriteProbabilty();
            fileWriteProbabilty.writeProbability(probability);
        }
        catch (Exception exception) {
            System.out.println("error" + exception);
        }


    }
}
