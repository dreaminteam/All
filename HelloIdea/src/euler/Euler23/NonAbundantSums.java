package euler.Euler23;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by dreaminteam on 15.10.14.
 */
public class NonAbundantSums {

    public static void main(String[] args) {

        NonAbundantSums nonAbundantSums = new NonAbundantSums();

        Set<Integer> noAmountAbundant = nonAbundantSums.noAmountOfAbundant(28123);
        System.out.println(nonAbundantSums.sumOfSet(noAmountAbundant));

    }

    public Set<Integer> noAmountOfAbundant(int stopNumber) {
        Set<Integer> result = new HashSet<>();
        Set<Integer> abund = abundantNumbers(stopNumber);

        for (int i = 1; i <= stopNumber; i++) {
            boolean test = true;
            Iterator<Integer> iterator = abund.iterator();
            while (iterator.hasNext()) {
                int nextAmount = iterator.next();
                if (i<=nextAmount) {
                    break;
                }
                if (abund.contains(i - nextAmount)) {
                    test = false;
                    break;
                }
            }
            if (test == true) {
                result.add(i);
            }
        }

        return result;
    }


    public Set<Integer> abundantNumbers(int stopNumber) {

        Set<Integer> result = new TreeSet<>();
        for (int i = 1; i <= stopNumber; i++) {
            if (abundant(i)) {
                result.add(i);
            }
        }
        return result;
    }


    public int sumOfDivisors(int number) {

        int result = 1;
        for (int i = 2; i <= number / 2; i++) {
            if (number % i == 0) {
                result += i;
            }
        }
        return result;
    }


    public boolean abundant(int number) {

        if (sumOfDivisors(number) > number) {
            return true;
        }
        return false;
    }


    public int sumOfSet(Set<Integer> set){
        int result=0;
        for (Integer integer:set){
            result+=integer;
        }
        return result;
    }
}
