import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Testing {

    public static void main(String[] args) throws IOException {
        FileReader fr = new FileReader("I:\\5th semester\\DBMS2\\testUCI.txt");
        FileReader fr1 = new FileReader("I:\\5th semester\\DBMS2\\outNursUCI.txt");
        BufferedReader br = new BufferedReader(fr);
        BufferedReader br1 = new BufferedReader(fr1);


        String line;
        int i=0,j=0, k=0, count=0;
        double[] parents = new double[6];
        double[] hasNurs = new double[10];
        double[] form = new double[8];
        double[] children = new double[8];
        double[] housing = new double[6];
        double[] finance = new double[2];
        double[] social = new double[6];
        double[] health = new double[6];
        double[] classs = new double[10];

        for (i=0;i<6;i++) parents[i]=0.00;
        for (i=0;i<10;i++) hasNurs[i]=0.00;
        for (i=0;i<8;i++) form[i]=0.00;
        for (i=0;i<8;i++) children[i]=0.00;
        for (i=0;i<6;i++) housing[i]=0.00;
        for (i=0;i<2;i++) finance[i]=0.00;
        for (i=0;i<6;i++) social[i]=0.00;
        for (i=0;i<6;i++) health[i]=0.00;
        for (i=0;i<10;i++) classs[i]=0.00;

        String[] temparr;
        while((line=br1.readLine())!=null){
//            System.out.println(line);
            temparr=line.split(",");
            if(count==0)for (i=0;i<6;i++) parents[i]=Double.parseDouble(temparr[i]);
            else if(count==1) for (i=0;i<10;i++) hasNurs[i]=Double.parseDouble(temparr[i]);
            else if(count==2) for (i=0;i<8;i++) form[i]=Double.parseDouble(temparr[i]);
            else if(count==3) for (i=0;i<8;i++) children[i]=Double.parseDouble(temparr[i]);
            else if(count==4) for (i=0;i<6;i++) housing[i]=Double.parseDouble(temparr[i]);
            else if(count==5) for (i=0;i<2;i++) finance[i]=Double.parseDouble(temparr[i]);
            else if(count==6) for (i=0;i<6;i++) social[i]=Double.parseDouble(temparr[i]);
            else if(count==7) for (i=0;i<6;i++) health[i]=Double.parseDouble(temparr[i]);
            else if(count==8) for (i=0;i<10;i++) classs[i]=Double.parseDouble(temparr[i]);

            count++;
        }

        double[] probconv = new double[1000];
        double[] probinconv = new double[1000];
        double temp=0.00;
        double itr_accuracy=0.00;
        int countconvyes=0, countinconvno=0;
        int countinconvyes=0, countconvno=0;
        for (i=0;i<1000;i++) probconv[i]=1.00;
        for (i=0;i<1000;i++) probinconv[i]=1.00;

        while ((line= br.readLine())!=null){
            String[] arr = line.split(",");
            int[] arr1 = new int[9];
            for (i = 0; i < 9; i++) {
                if (i == 0){
                    arr1[i] = getParents(arr[i]);
                    temp=parents[arr1[i]*2]+parents[arr1[i]*2+1];
                    probconv[j]*=parents[arr1[i]*2]/temp;
                    probinconv[j]*=parents[arr1[i]*2+1]/temp;
                }
                else if (i == 1) {
                    arr1[i] = getHasNurs(arr[i]);
                    temp=hasNurs[arr1[i]*2]+hasNurs[arr1[i]*2+1];
                    probconv[j]*=hasNurs[arr1[i]*2]/temp;
                    probinconv[j]*=hasNurs[arr1[i]*2+1] / temp;
                }
                else if (i == 2) {
                    arr1[i] = getForm(arr[i]);
                    temp=form[arr1[i]*2]+form[arr1[i]*2+1];
                    probconv[j]*=form[arr1[i]*2]/temp;
                    probinconv[j]*=form[arr1[i]*2+1]/temp;
                }
                else if (i == 3) {
                    arr1[i] = getChildren(arr[i]);
                    temp=children[arr1[i]*2]+children[arr1[i]*2+1];
                    probconv[j]*=children[arr1[i]*2]/temp;
                    probinconv[j]*=children[arr1[i]*2+1]/temp;
                }
                else if (i == 4) {
                    arr1[i] = getHousing(arr[i]);
                    temp=housing[arr1[i]*2]+housing[arr1[i]*2+1];
                    probconv[j]*=housing[arr1[i]*2]/temp;
                    probinconv[j]*=housing[arr1[i]*2+1]/temp;
                }
                else if (i == 5) {
                    arr1[i] = getFinance(arr[i]);
//                    temp=finance[arr1[i]*2]+finance[arr1[i]*2+1];
//                    probconv[j]*=finance[arr1[i]*2]/temp;
//                    probinconv[j]*=finance[arr1[i]*2+1]/temp;
                }
                else if (i == 6) {
                    arr1[i] = getSocial(arr[i]);
                    temp=social[arr1[i]*2]+social[arr1[i]*2+1];
                    probconv[j]*=social[arr1[i]*2]/temp;
                    probinconv[j]*=social[arr1[i]*2+1]/temp;
                }
                else if (i == 7) {
                    arr1[i] = getHealth(arr[i]);
                    temp=health[arr1[i]*2]+health[arr1[i]*2+1];
                    probconv[j]*=health[arr1[i]*2]/temp;
                    probinconv[j]*=health[arr1[i]*2+1]/temp;
                }
                else if (i == 8) {
                    arr1[i] = getClass(arr[i]);
                    temp=classs[arr1[i]*2]+classs[arr1[i]*2+1];
                    probconv[j]*=classs[arr1[i]*2]/temp;
                    probinconv[j]*=classs[arr1[i]*2+1]/temp;
                }
            }

            if (probconv[j]>probinconv[j]){
                if (arr1[5]==0) {
                    countconvyes++;
                    System.out.println("convenient : Yes");
                }
                else {
                    countconvno++;
                    System.out.println("convenient : No");
                }
            }
            else {
                if (arr1[5]==0) {
                    countinconvyes++;
                    System.out.println("inconvenient : No");
                }
                else {
                    countinconvno++;
                    System.out.println("inconvenient : Yes");
                }
            }

            j++;
        }
        itr_accuracy = (double)(countconvyes+countinconvno)/(countconvyes+countinconvno+countconvno+countinconvyes);
        System.out.println("Accuracy: "+itr_accuracy);
    }

    public static int getParents(String s) {
        if (s.equals("usual")) return 0;
        else if (s.equals("pretentious")) return 1;
        else if (s.equals("great_pret")) return 2;
        else return -1;
    }

    public static int getHasNurs(String s) {
        if (s.equals("proper")) return 0;
        else if (s.equals("less_proper")) return 1;
        else if (s.equals("improper")) return 2;
        else if (s.equals("critical")) return 3;
        else if (s.equals("very_crit")) return 4;
        else return -1;
    }

    public static int getForm(String s) {
        if (s.equals("complete")) return 0;
        else if (s.equals("completed")) return 1;
        else if (s.equals("incomplete")) return 2;
        else if (s.equals("foster")) return 3;
        else return -1;
    }

    public static int getHousing(String s) {
        if (s.equals("convenient")) return 0;
        else if (s.equals("less_conv")) return 1;
        else if (s.equals("critical")) return 2;
        else return -1;
    }

    public static int getChildren(String s) {
        if (s.equals("1")) return 0;
        else if (s.equals("2")) return 1;
        else if (s.equals("3")) return 2;
        else if (s.equals("more")) return 3;
        else return -1;
    }

    public static int getFinance(String s) {
        if (s.equals("convenient")) return 0;
        else if (s.equals("inconv")) return 1;
        else return -1;
    }
    public static int getSocial(String s) {
        if (s.equals("nonprob")) return 0;
        else if (s.equals("slightly_prob")) return 1;
        else if (s.equals("problematic")) return 2;
        else return -1;
    }

    public static int getHealth(String s) {
        if (s.equals("recommended")) return 0;
        else if (s.equals("priority")) return 1;
        else if (s.equals("not_recom")) return 2;
        else return -1;
    }
    public static int getClass(String s) {
        if (s.equals("not_recom")) return 0;
        else if (s.equals("recommend")) return 1;
        else if (s.equals("very_recom")) return 2;
        else if (s.equals("priority")) return 3;
        else if (s.equals("spec_prior")) return 4;
        else return -1;
    }
}
