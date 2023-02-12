import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) throws IOException {

        File file = new File("I:\\5th semester\\DBMS2\\nursery.data");
        File trainfile=new File("I:\\5th semester\\DBMS2\\trainUCI.txt");
        File testfile=new File("I:\\5th semester\\DBMS2\\testUCI.txt");

        FileWriter fileWriter1=new FileWriter(trainfile);
        FileWriter fileWriter2=new FileWriter(testfile);
        FileReader fr = new FileReader(file);

        BufferedReader br = new BufferedReader(fr);

        List<Integer> TrainNumber=new ArrayList<Integer>();
        List<Integer> TestNumber=new ArrayList<Integer>();

        String line;
        int i=0,j=0, k=0, count=0;

        Random random=new Random();
        while(i<11960){
            int n= random.nextInt(12960);
            if(!TrainNumber.contains(n)){
                TrainNumber.add(n);
                i++;
            }
        }

        for(i=0;i<12960;i++){
            if(!TrainNumber.contains(i))TestNumber.add(i);
        }

        while ((line= br.readLine())!=null){
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