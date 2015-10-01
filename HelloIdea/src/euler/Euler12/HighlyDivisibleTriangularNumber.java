package euler.Euler12;

import euler.Euler1.Euler3.LargestPrimeFactor;

/**
 * Created by dreaminteam on 13.10.14.
 */
public class HighlyDivisibleTriangularNumber {

    public static void main(String[] args) {

        HighlyDivisibleTriangularNumber hdtn = new HighlyDivisibleTriangularNumber();
        //System.out.println(hdtn.numberOfDivisors(6));
         System.out.println(hdtn.highlyDivisible(500));

    }

    /*
    Метод возвращает количество делителей числа
    @param number - рассматриваемое число
    Использовался алгоритм разложения на простые множители
    Количество делителей любого числа равно произведению степеней, увеличенное на 1, всех множителей в разложении

     */
    public int numberOfDivisors(int number) {

        int result = 1;
        if (number == 1) {
            return 1;
        }
        for (int i = 2; i <= number; i++) {
            int numDiv = 1;
            while (number % i == 0) {
                number = number / i;
                numDiv++;
            }
            result *= numDiv;
        }
        if (result == 1) {
            return 2;
        }
        return result;
    }

    /*
    Возвращает первое же число, количество делителей которого превосходит заданный параметр minimumNumberOfDivisors
     */
    public int highlyDivisible(int minimumNumberOfDivisors) {

        int i = 3;
        int devisors = 1;
        int triangularNumber = 3;
        while (devisors <= minimumNumberOfDivisors) {
            triangularNumber += i;
            devisors = numberOfDivisors(triangularNumber);
            i++;
        }
        return triangularNumber;
    }

}
