package euler.Euler14;

/**
 * Created by dreaminteam on 14.10.14.
 */
public class LongestCollatzSequence {

    public static void main(String[] args) {

        LongestCollatzSequence lcs = new LongestCollatzSequence();
        System.out.println(lcs.elementWithTheLongestSequence(1000000));

    }

    public int elementWithTheLongestSequence(int upperLimit) {

        int result = 0;
        long maxLength = 0;
        for (int i = 1; i <= upperLimit; i++) {
            long buff = sequenceLength(i);
//            System.out.println("количество элементов: "+buff);
            if (maxLength < buff) {
                maxLength = buff;
                result = i;
            }
        }
        return result;
    }

    /*
    Для заданного параметра возвращает количество элементов в последовательности с правилом:
    n → n/2 (n - чётное)
    n → 3n + 1 (n - нечётное)
     */
    public long sequenceLength(long initialElement) {

        long result = 1;
        long number = initialElement;
//        System.out.print(number + " >> ");
        while (number != 1) {
            if (number % 2 == 0) {
                number = number / 2;
            } else {
                number = 3 * number + 1;
            }
            result++;
//            System.out.print(number + " >> ");
        }
        System.out.println();
        return result;
    }

}
