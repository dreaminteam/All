package euler.Euler1.Euler3;

import java.util.*;

/**
 * Created by dreaminteam on 7.10.14.
 */
public class LargestPrimeFactor {

    public static void main(String[] args) {

        LargestPrimeFactor largestPrimeFactor = new LargestPrimeFactor();
        // List<Integer> primes = largestPrimeFactor.primesNumbers(100);

       // System.out.println(largestPrimeFactor.greatestPrimeDivisor(600851475143L));

        //Euler10
        System.out.println(largestPrimeFactor.euler10Answer(2000000));

    }

    public long greatestPrimeDivisor(long number) {
        boolean check = false;
        for (long i = 2; i <= number / 2; i++)
            if (number % i == 0) {
                long devisor = number / i;
                check = checkPrimes(devisor);
                if (check) {
                    return devisor;
                }
            }
        return number;
    }


    public boolean checkPrimes(long number) {
        boolean result = true;
        if (number > 2) {
            for (long i = 2; i <= Math.sqrt(number); i++) {
                if (number % i == 0) {
                    result = false;
                    break;
                }
            }
        } else {
            if (number < 1) {
                result = false;
            }
        }
        return result;
    }

    public ArrayList primesNumbers(int stop) {

        ArrayList<Integer> result = new ArrayList<>();
        result.add(1);
        result.add(2);
        result.add(3);
        result.add(5);
        result.add(7);

        for (int i = 8; i <= stop; i++) {
            boolean reply = true;
            int j = 1;
            int sqrt = (int) Math.sqrt(i);
            while (result.get(j) <= sqrt) {
                if (i % (result.get(j)) == 0) {
                    reply = false;
                    break;
                }
                j++;
            }
            if (reply) {
                result.add(i);
            }
        }
        return result;
    }

    public long euler10Answer(long stop) {

        long result = 5;
        long number=5;
        while (number<stop){
            if (checkPrimes(number)){
                result+=number;
            }
            number++;
        }
        return result;
    }


}

