import java.io.*;

public class Training {

    public static void main(String[] args) throws IOException {
        File file = new File("I:\\5th semester\\DBMS2\\trainUCI.txt");
        File file1= new File("I:\\5th semester\\DBMS2\\outNursUCI.txt");
        FileReader fr = new FileReader(file);
        FileWriter fileWriter=new FileWriter(file1);

        double[][] parents=new double[3][5];           //usual, pretentious, great_pret
        double[][] has_nurs=new double[5][5];          //proper, less_proper, improper, critical, very_crit
        double[][] form=new double[4][5];              //complete, completed, incomplete, foster
        double[][] children=new double[4][5];          //1, 2, 3, more
        double[][] housing=new double[3][5];           //convenient, less_conv, critical
        double[][] finance=new double[3][5];           //convenient, inconv
        double[][] social=new double[3][5];            //non-prob, slightly_prob, problematic
        double[][] health=new double[3][5];            //recommended, priority, not_recom
        double[][] classs=new double[5][5];            //not_recom, recommend, very_recom, priority, spec_prior

        for(int i=0;i<3;i++){
            for(int j=0;j<5;j++){
                parents[i][j]=0;
            }
            for (int j=0;j<5;j++){
                has_nurs[i][j]=0;
            }
            for (int j=0;j<4;j++){
                form[i][j]=0;
            }
            for (int j=0;j<4;j++){
                children[i][j]=0;
            }
            for (int j=0;j<3;j++){
                housing[i][j]=0;
            }
            for (int j=0;j<3;j++){
                finance[i][j]=0;
            }
            for (int j=0;j<3;j++){
                social[i][j]=0;
            }
            for (int j=0;j<3;j++){
                health[i][j]=0;
            }
            for (int j=0;j<5;j++){
                classs[i][j]=0;
            }
        }



        BufferedReader br = new BufferedReader(fr);
        String line;
        String[] tempArr;
        int i=0,j=0;
        double total=0.00;

        while ((line= br.readLine())!=null){
            tempArr = line.split(",");
            parents[getParents(tempArr[0])][getFinance(tempArr[5])]++;
            has_nurs[getHasNurs(tempArr[1])][getFinance(tempArr[5])]++;
            form[getForm(tempArr[2])][getFinance(tempArr[5])]++;
            children[getChildren(tempArr[3])][getFinance(tempArr[5])]++;
            housing[getHousing(tempArr[4])][getFinance(tempArr[5])]++;
            social[getSocial(tempArr[6])][getFinance(tempArr[5])]++;
            health[getHealth(tempArr[7])][getFinance(tempArr[5])]++;
            classs[getClass(tempArr[8])][getFinance(tempArr[5])]++;
        }

        for(i=0;i<3;i++){
            total=parents[i][0]+parents[i][1];
            parents[i][0]=parents[i][0]/total;
            parents[i][1]=parents[i][1]/total;
        }
        for(i=0;i<5;i++){
            total=has_nurs[i][0]+has_nurs[i][1];
            has_nurs[i][0]=has_nurs[i][0]/total;
            has_nurs[i][1]=has_nurs[i][1]/total;
        }
        for(i=0;i<4;i++){
            total=form[i][0]+form[i][1];
            form[i][0]=form[i][0]/total;
            form[i][1]=form[i][1]/total;
        }
        for(i=0;i<4;i++){
            total=children[i][0]+children[i][1];
            children[i][0]=children[i][0]/total;
            children[i][1]=children[i][1]/total;
        }
        for(i=0;i<3;i++){
            total=housing[i][0]+housing[i][1];
            housing[i][0]=housing[i][0]/total;
            housing[i][1]=housing[i][1]/total;
        }
        for(i=0;i<3;i++){
            total=social[i][0]+social[i][1];
            social[i][0]=social[i][0]/total;
            social[i][1]=social[i][1]/total;
        }
        for(i=0;i<3;i++){
            total=health[i][0]+health[i][1];
            health[i][0]=health[i][0]/total;
            health[i][1]=health[i][1]/total;
        }
        for(i=0;i<5;i++){
            total=classs[i][0]+classs[i][1];
            classs[i][0]=classs[i][0]/total;
            classs[i][1]=classs[i][1]/total;
        }

        for(i=0;i<3;i++){
            for(j=0;j<2;j++){
                fileWriter.append(String.valueOf(parents[i][j] + ","));
                System.out.print(parents[i][j]+" ");
            }
            fileWriter.append("\n");
            System.out.println();
        }
        System.out.println();
        for(i=0;i<5;i++){
            for(j=0;j<2;j++){
                fileWriter.append(String.valueOf(has_nurs[i][j] + ","));
                System.out.print(has_nurs[i][j]+" ");
            }
            fileWriter.append("\n");
            System.out.println();
        }
        System.out.println();
        for(i=0;i<4;i++){
            for(j=0;j<2;j++){
                fileWriter.append(String.valueOf(form[i][j] + ","));
                System.out.print(form[i][j]+" ");
            }
            fileWriter.append("\n");
            System.out.println();
        }
        System.out.println();
        for(i=0;i<4;i++){
            for(j=0;j<2;j++){
                fileWriter.append(String.valueOf(children[i][j] + ","));
                System.out.print(children[i][j]+" ");
            }
            fileWriter.append("\n");
            System.out.println();
        }
        System.out.println();
        for(i=0;i<3;i++){
            for(j=0;j<2;j++){
                fileWriter.append(String.valueOf(housing[i][j] + ","));
                System.out.print(housing[i][j]+" ");
            }
            fileWriter.append("\n");
            System.out.println();
        }
        System.out.println();
        for(i=0;i<3;i++){
            for(j=0;j<2;j++){
                fileWriter.append(String.valueOf(social[i][j] + ","));
                System.out.print(social[i][j]+" ");
            }
            fileWriter.append("\n");
            System.out.println();
        }
        System.out.println();
        for(i=0;i<3;i++){
            for(j=0;j<2;j++){
                fileWriter.append(String.valueOf(health[i][j] + ","));
                System.out.print(health[i][j]+" ");
            }
            fileWriter.append("\n");
            System.out.println();
        }
        System.out.println();
        for(i=0;i<5;i++){
            for(j=0;j<2;j++){
                fileWriter.append(String.valueOf(classs[i][j] + ","));
                System.out.print(classs[i][j]+" ");
            }
            fileWriter.append("\n");
            System.out.println();
        }
        System.out.println();

        fileWriter.flush();
        fileWriter.close();

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
