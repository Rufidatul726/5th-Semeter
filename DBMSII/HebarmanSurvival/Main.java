import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) throws IOException {

        File file = new File("I:\\5th semester\\DBMS2\\HabermanSurvival.txt");
        File trainfile=new File("I:\\5th semester\\DBMS2\\trainUCIData.txt");
        File testfile=new File("I:\\5th semester\\DBMS2\\testUCIdata.txt");

        FileWriter fileWriter1=new FileWriter(trainfile);
        FileWriter fileWriter2=new FileWriter(testfile);
        FileReader fr = new FileReader(file);

        BufferedReader br = new BufferedReader(fr);

        List<Integer> TrainNumber=new ArrayList<Integer>();
        List<Integer> TestNumber=new ArrayList<Integer>();

        String line;
        String[] tempArr;

        int i=0,j=0, k=0, count=0;
        int dAge[]=new int[100];
        int dYear[]=new int[100];
        int dNode[]=new int[100];


        int temp1=0, temp2=0, temp3=0, temp4=0;
        int yes=0, no=0;

        Random random=new Random();
        while(i<290){
            int n= random.nextInt(306);
            if(!TrainNumber.contains(n)){
                TrainNumber.add(n);
                i++;
            }
        }

        for(i=0;i<306;i++){
            if(!TrainNumber.contains(i))TestNumber.add(i);
        }

        while ((line= br.readLine())!=null){
            tempArr = line.split(",");
            temp1=Integer.parseInt(tempArr[0]);
            temp2=Integer.parseInt(tempArr[1]);
            temp3=Integer.parseInt(tempArr[2]);
            temp4=Integer.parseInt(tempArr[3]);

            if(TrainNumber.contains(count)){
                System.out.println("that line "+ count);
                fileWriter1.append(line + "\n");
            }

            else if(TestNumber.contains(count)){
                System.out.println("this line "+ count);
                fileWriter2.append(line +"\n");
            }

            else{
                System.out.println(count + " not added");
            }

            count++;
        }
        fileWriter1.close();
        fileWriter2.close();
    }
}