package euler.Euler11;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by dreaminteam on 13.10.14.
 */
public class LargestProductInAGrid {

    public static void main(String[] args) throws FileNotFoundException{

        LargestProductInAGrid lpg=new LargestProductInAGrid();
        int[] array=lpg.init("/home/dreaminteam/IdeaProjects/HelloIdea/src/euler/Euler11/data.txt");
        System.out.println(lpg.largestHorizontal(array));
        System.out.println(lpg.largestVertical(array));
        System.out.println(lpg.largestDiagonallyToTheRight(array));
        System.out.println(lpg.largestDiagonallyToTheLeft(array));
    }

    public int largestHorizontal(int[] array){

        int result=0;
        int index=0;
        while (index<380){
            for (int j=index;j<index+16;j++){
                int mult=array[j]*array[j+1]*array[j+2]*array[j+3];
                if (mult>result){
                    result=mult;
                }
            }
            index+=20;
        }
        return result;
    }

    public int largestVertical(int[] array){

        int result=0;
        int index=0;
        while (index<340){
            for (int j=index;j<index+20;j++){
                int mult=array[j]*array[j+20]*array[j+40]*array[j+60];
                if (mult>result){
                    result=mult;
                }
            }
            index+=20;
        }
        return result;
    }

    public int largestDiagonallyToTheRight (int[] array){

        int result=0;
        int index=0;
        while (index<340){
            for (int j=index;j<index+16;j++){
                int mult=array[j]*array[j+21]*array[j+42]*array[j+63];
                if (mult>result){
                    result=mult;
                }
            }
            index+=20;
        }
        return result;
    }

    public int largestDiagonallyToTheLeft (int[] array){

        int result=0;
        int index=3;
        while (index<340){
            for (int j=index;j<index+16;j++){
                int mult=array[j]*array[j+19]*array[j+38]*array[j+57];
                if (mult>result){
                    result=mult;
                }
            }
            index+=20;
        }
        return result;
    }

    public int[] init(String path) throws FileNotFoundException{

        Scanner scan=new Scanner (new File(path));
        StringBuffer sBuf=new StringBuffer();
        while (scan.hasNext()){
            sBuf.append(scan.nextLine()+" ");
        }
        String[] strings=sBuf.toString().split(" ");
        int[] result=new int[strings.length];
        for (int i=0;i<strings.length;i++){
             result[i]=Integer.valueOf(strings[i]);
        }
        return result;
    }

}
