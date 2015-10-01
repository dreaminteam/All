package euler.Euler7;

import euler.Euler1.Euler3.LargestPrimeFactor;

/**
 * Created by dreaminteam on 10.10.14.
 */
public class Prime10001 {

    public static void main(String[] args) {

        Prime10001 prime10001 = new Prime10001();
        System.out.println(prime10001.primeInARow(10001));
    }

    public long primeInARow(int number) {
        int counter = 1;
        long i = 3;
        while (counter != number) {
            while (!new LargestPrimeFactor().checkPrimes(i)) {
                i++;
            }
            i++;
            counter++;
        }
        return i-1;
    }
}

