import java.io.*;

/* 1. Age of patient at time of operation (numerical)
   2. Patient's year of operation (year - 1900, numerical)
   3. Number of positive axillary nodes detected (numerical)
   4. Survival status (class attribute)
         1 = the patient survived 5 years or longer
         2 = the patient died within 5 year
 */

public class Training {
    public static int[] posage=new int[310];
    public static int[] negage=new int[310];    //age is greater than 30 and less than 83,
    public static int[] posyear=new int[310];      //year is greater than 58 and less than 69,
    public static int[] negyear=new int[310];
    public static int[] posnodes=new int[310];     //nodes is greater than 0 and less than 52,
    public static int[] negnodes=new int[310];
    public static int[] status=new int[310];        //status is 1 or 2

//    public static double[][][] patient=new double[age.length][year.length][nodes.length];
//    public static double[][][] patient1=new double[age.length][year.length][nodes.length];
    public static void main(String[] args) throws IOException {

        File file = new File("I:\\5th semester\\DBMS2\\trainUCIData.txt");
        FileReader fr = new FileReader(file);

        BufferedReader br = new BufferedReader(fr);

        String line;
        String[] tempArr;
        int i=0,j=0, k=0, count=0;
        int dAge[]=new int[100];
        int dYear[]=new int[100];
        int dNode[]=new int[100];

        int posageLength=0, negageLength=0, negyearLength=0,  posyearLength=0, negnodesLength=0,  posnodesLength=0;
        int distinctage=0, distinctyear=0, distinctNode=0;
        int temp1=0, temp2=0, temp3=0, temp4=0;
        int yes=0, no=0;

        while ((line= br.readLine())!=null){
            tempArr = line.split(",");
            temp1=Integer.parseInt(tempArr[0]);
            temp2=Integer.parseInt(tempArr[1]);
            temp3=Integer.parseInt(tempArr[2]);
            temp4=Integer.parseInt(tempArr[3]);

            if(temp4==1){
                posage[temp1]++;
                posyear[temp2]++;
                posnodes[temp3]++;
                yes++;
                posageLength++;
                posyearLength++;
                posnodesLength++;
            }
            else{
                negage[temp1]++;
                negyear[temp2]++;
                negnodes[temp3]++;
                no++;
                negageLength++;
                negyearLength++;
                negnodesLength++;
            }
            if((posage[temp1]==1 && negage[temp1]==0) || (negage[temp1]==1 && posage[temp1]==0)){
                dAge[distinctage]=temp1;
                System.out.println("No: "+ distinctage+ " age: " + dAge[distinctage]);
                distinctage++;
            }

            if((posyear[temp2]==1 && negyear[temp2]==0) || (posyear[temp2]==0 && negyear[temp2]==1)){
                dYear[distinctyear]=temp2;
                distinctyear++;
            }

            if((posnodes[temp3]==1 && negnodes[temp3]==0)|| (posnodes[temp3]==0 && negnodes[temp3]==1)){
                dNode[distinctNode]=temp3;
                distinctNode++;
            }

            count++;
        }

        System.out.println("total Age:" + distinctage);

        double probOfAge[]=new double[distinctage];
        for(i=0;i<distinctage;i++){
            probOfAge[i]=0.000;
        }
        double tempx = 0,tempy=0;

        for(i=0;i<distinctage;i++){
            System.out.println(negage[dAge[i]] + " " + no);
            if(negage[dAge[i]]==0)probOfAge[i]=0.00;
            else{
                tempx=(double)posage[dAge[i]]/yes;
                tempy=(double)negage[dAge[i]]/no ;
                probOfAge[i] = tempx/tempy;
            }
            System.out.println( " Probability: "+probOfAge[i]);
        }

//        while((line = br.readLine()) != null){
//            tempArr = line.split(",");
//            age[i]=Integer.parseInt(tempArr[0]);
//
//            year[i]=Integer.parseInt(tempArr[1]);
//            nodes[i]=Integer.parseInt(tempArr[2]);
//            status[i]=Integer.parseInt(tempArr[3]);
//            if(status[i]==1){
//                patient[age[i]][year[i]][nodes[i]]+=1;
//                yes++;
//            }
//            else if(status[i]==2){
//                patient1[age[i]][year[i]][nodes[i]]+=1;
//                no++;
//            }
//            i++;
//        }
//        count=i;
//        System.out.println("count" + count);
//
//        double[] probabilityYes=new double[310];
//        double[] probabilityNo=new double[310];
//        double[] probability=new double[310];
//        int m=0;
//
//        for(i=0;i<count;i++){
//            for(j=0;j<count;j++){
//                for(k=0;k<count;k++){
//                    if(patient1[i][j][k]!=0){
//                        patient[i][j][k]=patient[i][j][k]/yes;
//                        patient1[i][j][k]=patient1[i][j][k]/no;
//                        probability[m]=patient[i][j][k]/(patient1[i][j][k]);
//                        System.out.println("probability["+m+"]="+probability[m]);
//                        m++;
//                    }
//                }
//            }
//        }


    }
}
