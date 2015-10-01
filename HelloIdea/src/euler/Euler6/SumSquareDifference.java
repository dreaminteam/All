package euler.Euler6;

/**
 * Created by dreaminteam on 10.10.14.
 */
public class SumSquareDifference {

    public static void main(String[] args) {

        SumSquareDifference sumSquareDifference=new SumSquareDifference();
        int sumSquare=sumSquareDifference.sumOfTheSquares(100);
        int squareSum=sumSquareDifference.squareOfTheSum(100);
        System.out.println(squareSum-sumSquare);

    }

    public int sumOfTheSquares(int number){
        int result=0;
        for (int i=1;i<=number;i++){
            result+=(i*i);
        }
        return result;
    }

    public int squareOfTheSum(int number){
        int result=0;
        for (int i=1;i<=number;i++){
            result+=i;
        }
        return result*result;
    }
}
