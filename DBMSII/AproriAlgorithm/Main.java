import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static List<String>items=new ArrayList<String>();
    public static List<String>transaction=new ArrayList<String>();
    public static List<Integer>support=new ArrayList<Integer>();

    public static void main(String[] args) throws IOException {
        int i=0;
        String[] temp=new String[100];
        File file = new File("I:\\5th semester\\DBMS2\\Book.csv");
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line;
        String splitBy = ",";
        while ((line = bufferedReader.readLine()) != null) {
            i=0;
            transaction.add(line);
            temp= line.split(splitBy);
            for (String s : temp) {
                if(!items.contains(temp[i])){
                    items.add(temp[i]);
                    support[i]=1;
                }
                else support[items.get()]++;
                i++;
            }
        }

        i=0;
        while (transaction.size()>i){
            System.out.println(transaction.get(i));
            i++;
        }


    }
}