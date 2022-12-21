package ImageProcessing;

public class Probability {

    public double[][][] skinProbability= new double[256][256][256];
    public double[][][] nonSkinProbability= new double[256][256][256];

    public double[][][] probabiityArray= new double[256][256][256];

    public void calculateProbability(IdentifySkinNonskin identifySkinNonskin){

        for(int i=0;i<256;i++){
            for(int j=0;j<256;j++){
                for (int k=0;k<256;k++){
                    if(identifySkinNonskin.skinArray[i][j][k]!=0){
                        skinProbability[i][j][k] = identifySkinNonskin.skinArray[i][j][k]/(double) identifySkinNonskin.skinCount;
                    }
                    if(identifySkinNonskin.nonSkinArray[i][j][k]!=0){
                        nonSkinProbability[i][j][k] = identifySkinNonskin.nonSkinArray[i][j][k]/(double) identifySkinNonskin.nonSkinCount;
                    }

                    if(nonSkinProbability[i][j][k]!=0){
                        probabiityArray[i][j][k] = skinProbability[i][j][k]/nonSkinProbability[i][j][k];
                        //System.out.println("Probability calculated" + skinProbability[i][j][k]+ " "+ nonSkinProbability[i][j][k]+ " " +probabiityArray[i][j][k]);
                    }
                    if(nonSkinProbability[i][j][k]!=0){
                        System.out.println("focus" + identifySkinNonskin.nonSkinArray[i][j][k]+ " "+ identifySkinNonskin.nonSkinCount+ " " +nonSkinProbability[i][j][k]);
                    }

                }
            }
        }
    }


}
