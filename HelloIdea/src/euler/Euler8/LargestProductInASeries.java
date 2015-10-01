package euler.Euler8;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Scanner;

/**
 * Created by dreaminteam on 13.10.14.
 */
public class LargestProductInASeries {

    public static void main(String[] args) throws FileNotFoundException{

        LargestProductInASeries lps=new LargestProductInASeries();
        String number=lps.init("/home/dreaminteam/IdeaProjects/HelloIdea/src/euler/Euler8/data.txt");
        System.out.println(number);
        System.out.println(lps.largestProduct(number));

    }


    public String init(String path) throws FileNotFoundException{

        Scanner scan=new Scanner(new File(path));
        StringBuffer stringBuffer=new StringBuffer();
        while (scan.hasNext()){
            stringBuffer.append(scan.nextLine());
        }
        return stringBuffer.toString();
    }

    public long largestProduct(String number){

        long result=0;

        for (int i=0;i<number.length()-13;i++){
            long mult=1;
            for (int j=i;j<i+13;j++){
                mult*=(number.charAt(j)-48);
            }
            if (mult>result){
                result=mult;
            }
        }
        return result;
    }
}
