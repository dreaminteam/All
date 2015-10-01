package euler.Euler21;

/**
 * Created by dreaminteam on 15.10.14.
 */
public class AmicableNumbers {

    public static void main(String[] args) {

        AmicableNumbers amicableNumbers = new AmicableNumbers();
        System.out.println(amicableNumbers.sumAmicableNumbers(10000));

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

    public boolean amicableNumber(int number) {
        int sumDev=sumOfDivisors(number);
        int sumDevDev=sumOfDivisors(sumDev);
        if (sumOfDivisors(sumOfDivisors(number)) == number && sumDev!=sumDevDev) {
            return true;
        }
        return false;
    }


    public int sumAmicableNumbers(int border){

        int result=0;
        for (int i=1;i<border;i++){
            if (amicableNumber(i)){
                result+=i;
            }
        }
        return result;
    }
}
