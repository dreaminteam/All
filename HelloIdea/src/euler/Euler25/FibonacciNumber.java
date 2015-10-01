package euler.Euler25;

import java.math.BigInteger;

/**
 * Created by dreaminteam on 16.10.14.
 */
public class FibonacciNumber {

    public static void main(String[] args) {

        FibonacciNumber fibNumber = new FibonacciNumber();
        // System.out.println(fibNumber.numberFibonacci(100000));
        // System.out.println(fibNumber.lengthBigInteger(fibNumber.numberFibonacci(70000)));
        //System.out.println(fibNumber.firstNumberFixedLength(1000));
        System.out.println(1%3);

    }


    public BigInteger numberFibonacci(int index) {

        if (index == 1 | index == 2) {
            return BigInteger.valueOf(1);
        }

        BigInteger f3 = BigInteger.valueOf(0);
        BigInteger f1 = BigInteger.valueOf(1);
        BigInteger f2 = BigInteger.valueOf(1);
        for (int i = 3; i <= index; i++) {
            f3 = f1.add(f2);
            f1 = f2;
            f2 = f3;
        }
        return f3;
    }


    public int firstNumberFixedLength(int fixedLength) {
        int length = 0;
        int index=2;
        BigInteger f3 = BigInteger.valueOf(0);
        BigInteger f1 = BigInteger.valueOf(1);
        BigInteger f2 = BigInteger.valueOf(1);
        while (length < fixedLength) {
            f3 = f1.add(f2);
            f1 = f2;
            f2 = f3;
            length = lengthBigInteger(f3);
            index++;
        }
        return index;
    }


    public int lengthBigInteger(BigInteger number) {

        int result = number.toString().length();
        return result;
    }
}
