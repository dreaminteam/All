package euler.Euler2;

/**
 * Created by dreaminteam on 7.10.14.
 */
public class FibonacciNumber {

    public static void main(String[] args) {

        System.out.println(Fibonacci(4000000));

    }

    public static int Fibonacci(int stop){

        int result=2;
        int f1=1;
        int f2=2;
        int f3=f1+f2;
        while (f3<=stop){
            if (f3%2==0){result+=f3;}
            f1=f2;
            f2=f3;
            f3=f1+f2;

        }

        return result;
    }
}
