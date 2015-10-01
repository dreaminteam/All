package euler.Euler13;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigInteger;
import java.util.Scanner;

/**
 * Created by dreaminteam on 13.10.14.
 */
public class LargeSum {

    public static void main(String[] args) throws FileNotFoundException {

        String path = "/home/dreaminteam/IdeaProjects/HelloIdea/src/euler/Euler13/data.txt";
        Scanner scan = new Scanner(new File(path));
        BigInteger sum = BigInteger.valueOf(0);
        while (scan.hasNext()) {
            BigInteger b = new BigInteger(scan.nextLine());
            sum = sum.add(b);
        }
        System.out.println(sum.toString());

        /*
        Task Euler16
         */

        BigInteger euler16 = BigInteger.valueOf(2).pow(1000);
        String str = euler16.toString();
        int sumStr = 0;
        for (int i = 0; i < str.length(); i++) {
            sumStr = sumStr + Integer.parseInt(String.valueOf(str.charAt(i)));
        }
        System.out.println("Answer Euler16 Task: " + sumStr);

        /*
        Task Euler20
         */
        BigInteger euler20=BigInteger.valueOf(1);
        for (int i = 1; i <= 100; i++) {
            euler20=euler20.multiply(BigInteger.valueOf(i));
        }
        String str20 = euler20.toString();
        int sumStr20 = 0;
        for (int i = 0; i < str20.length(); i++) {
            sumStr20 = sumStr20 + Integer.parseInt(String.valueOf(str20.charAt(i)));
        }
        System.out.println("Answer Euler20 Task: " + sumStr20);

    }


}


