package Puke;
import java.util.Arrays;
import java.util.Scanner;
public class Puke {
    public static String convert(String str){
        str = str.replaceAll(" ", "");
        str = str.replaceAll(":", "");
        str = str.replaceAll("Black", "");
        return str.replaceAll("White", "");
    }
    public static int tonumber(char c) {
        if(c=='J') return 11;
        if(c=='Q') return 12;
        if(c=='K') return 13;
        if(c=='A') return 14;
        else return c-'0';
    }
    public static int Level(String str){
        char[] strarry = str.toCharArray();
        int[] numberarry = new int[5];
        char[] colorarry = new char[5];
        int i,j=0;
        Boolean shun = false;
        Boolean tonghua = false;
        Boolean santiao = false;
        Boolean liangdui = false;
        Boolean duizi = false;
        for(i=0;i<10;i=i+2,j++)
        {
            numberarry[j]=tonumber(strarry[i]);
            colorarry[j] =strarry[i+1];
        }
        Arrays.parallelSort(numberarry);
        for(i=0,j=0;i<4;i++)
        {
            if((numberarry[i+1]-numberarry[i])==0) j++;
        }
        for(i=0;i<4;i++)
        {
            if((numberarry[i+1]-numberarry[i])!=1) break;
        }
        if(i==4||(i==3)&&numberarry[4]==14&&numberarry[3]==5)
        {
            shun = true;
        }
        if(numberarry[0]==numberarry[2]||numberarry[1]==numberarry[3]||numberarry[2]==numberarry[4]) {
            santiao = true;
        }
        else if(j==2)
        {
            liangdui=true;
        }
        else if(j==1)
        {
            duizi=true;
        }
        for(i=0;i<4;i++)
        {
            if(colorarry[i]!=colorarry[i+1]) break;
        }
        if(i==4)
        {
            tonghua = true;
        }
        if(tonghua&&shun) return 7;
        else if(tonghua) return 6;
        else if(shun) return 5;
        else if(santiao) return 4;
        else if(liangdui) return 3;
        else if(duizi) return 2;
        else return 1;
    }
    public static int compare7(String str1,String str2)
    {
        char[] strarry1 = str1.toCharArray();
        char[] strarry2 = str2.toCharArray();
        int[] numberarry1 = new int[5];
        int[] numberarry2 = new int[5];
        int i,j=0;
        for(i=0;i<10;i=i+2,j++)
        {
            numberarry1[j]=tonumber(strarry1[i]);
            numberarry2[j]=tonumber(strarry2[i]);
        }
        Arrays.parallelSort(numberarry1);
        Arrays.parallelSort(numberarry2);
        if((numberarry1[3]>numberarry2[3])||(numberarry1[3]==numberarry2[3])&&(numberarry1[4]<numberarry2[4])) return 1;
        else if((numberarry2[3]>numberarry1[3])||(numberarry2[3]==numberarry1[3])&&(numberarry2[4]<numberarry1[4])) return 0;
        else return -1;
    }
    public static int compare6(String str1,String str2)
    {
        char[] strarry1 = str1.toCharArray();
        char[] strarry2 = str2.toCharArray();
        int[] numberarry1 = new int[5];
        int[] numberarry2 = new int[5];
        int i,j=0;
        for(i=0;i<10;i=i+2,j++)
        {
            numberarry1[j]=tonumber(strarry1[i]);
            numberarry2[j]=tonumber(strarry2[i]);
        }
        Arrays.parallelSort(numberarry1);
        Arrays.parallelSort(numberarry2);
        for(i=4;i>=0;i--)
        {
            if(numberarry1[i]>numberarry2[i]) return 1;
            if(numberarry1[i]<numberarry2[i]) return 0;
        }
        return -1;
    }
    public static int compare4(String str1,String str2)
    {
        char[] strarry1 = str1.toCharArray();
        char[] strarry2 = str2.toCharArray();
        int[] numberarry1 = new int[5];
        int[] numberarry2 = new int[5];
        int i,j=0;
        for(i=0;i<10;i=i+2,j++)
        {
            numberarry1[j]=tonumber(strarry1[i]);
            numberarry2[j]=tonumber(strarry2[i]);
        }
        Arrays.parallelSort(numberarry1);
        Arrays.parallelSort(numberarry2);
        if(numberarry1[2]>numberarry2[2]) return 1;
        else if(numberarry1[2]<numberarry2[2]) return 0;
        else return compare6(str1,str2);
    }
    public static int compare3(String str1,String str2)
    {
        char[] strarry1 = str1.toCharArray();
        char[] strarry2 = str2.toCharArray();
        int[] numberarry1 = new int[5];
        int[] numberarry2 = new int[5];
        int[] arr1 = new int[3];
        int[] arr2 = new int[3];
        int i,j=0;
        for(i=0;i<10;i=i+2,j++)
        {
            numberarry1[j]=tonumber(strarry1[i]);
            numberarry2[j]=tonumber(strarry2[i]);
        }
        Arrays.parallelSort(numberarry1);
        Arrays.parallelSort(numberarry2);
        for(i=3;i>=0;i--)
        {
            if(numberarry2[i+1]==numberarry2[i])
            {
                numberarry2[i]=10*numberarry2[i];
                numberarry2[i+1]=0;
            }
            if(numberarry1[i+1]==numberarry1[i])
            {
                numberarry1[i]=10*numberarry1[i];
                numberarry1[i+1]=0;
            }
        }
        Arrays.parallelSort(numberarry1);
        Arrays.parallelSort(numberarry2);
        for(i=4;i>=0;i++)
        {
            if(numberarry1[i]>numberarry2[i]) return 1;
            if(numberarry1[i]<numberarry2[i]) return 0;
        }
        return -1;
    }
    public static int GetValueByString(String str) {
        int flag=-1;
        str = convert(str);
        String str1=str.substring(0, 10);
        String str2=str.substring(10, 20);
        if(Level(str1)>Level(str2)) flag=1;
        else if(Level(str1)<Level(str2)) flag=0;
        else
        {
            if(((Level(str1)==7)||(Level(str1)==5))) flag=compare7(str1,str2);
            if(((Level(str1)==6)||(Level(str1)==1))) flag=compare6(str1,str2);
            if(((Level(str1)==3)||(Level(str1)==2))) flag=compare3(str1,str2);
            if((Level(str1)==4)) flag=compare4(str1,str2);
        }
        return flag;
    }

    public static void main(String[] args) {
        int flag=-1;
        String str;
        Scanner in = new Scanner(System.in);
        str = in.nextLine();
        str = convert(str);
        String str1=str.substring(0, 10);
        String str2=str.substring(10, 20);
        if(Level(str1)>Level(str2)) flag=1;
        else if(Level(str1)<Level(str2)) flag=0;
        else
        {
            if(((Level(str1)==7)||(Level(str1)==5))) flag=compare7(str1,str2);
            if(((Level(str1)==6)||(Level(str1)==1))) flag=compare6(str1,str2);
            if(((Level(str1)==3)||(Level(str1)==2))) flag=compare3(str1,str2);
            if((Level(str1)==4)) flag=compare4(str1,str2);
        }
        if(flag==1) System.out.println("Black wins");
        else if(flag==0) System.out.println("White wins");
        else System.out.println("Tie");
    }
}
