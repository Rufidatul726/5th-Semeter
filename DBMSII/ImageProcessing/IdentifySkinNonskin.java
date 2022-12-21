package ImageProcessing;

import java.io.File;
import java.io.IOException;

public class IdentifySkinNonskin {
    public double[][][] skinArray= new double[256][256][256];
    public double[][][] nonSkinArray= new double[256][256][256];
    public int imagesize;

    public double sumSkin=0;
    public double sumNonSkin=0;
    public File fileRead;

    public int skinCount=0;
    public int nonSkinCount=0;

    public void identifySkin(int[][][] imageArray) throws IOException {

        try{
            for(int i=0;i< 256;i++){
                for (int j=0;j< 256;j++){
                    for (int k=0;k< 256;k++){
                            if (i>220 && j>220 && k>220) {
                                skinCount += imageArray[i][j][k];
                                skinArray[i][j][k] = (double) imageArray[i][j][k];
                            }
                            else{
                                nonSkinCount += imageArray[i][j][k];
                                nonSkinArray[i][j][k] = (double)imageArray[i][j][k];
                            }

                    }
                }
            }

            for(int i=0;i< 256;i++){
                for (int j=0;j< 256;j++){
                    for (int k=0;k< 256;k++){
                        if(skinArray[i][j][k]!=0 && skinCount!=0)sumSkin += skinArray[i][j][k]/(double) skinCount;
                        if(nonSkinArray[i][j][k]!=0 && nonSkinCount!=0)sumNonSkin += nonSkinArray[i][j][k]/(double) nonSkinCount;
                    }
                }
            }

            System.out.println("Probability calculated" + sumSkin+ " "+ sumNonSkin+ " " +sumSkin/sumNonSkin);
        }
        catch (Exception exception){
            System.out.println("error" + exception);
        }
    }


}
