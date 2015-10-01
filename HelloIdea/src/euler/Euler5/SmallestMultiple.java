package euler.Euler5;

/**
 * Created by dreaminteam on 10.10.14.
 */
public class SmallestMultiple {

    public static void main(String[] args) {

        SmallestMultiple smallestMultiple = new SmallestMultiple();
        System.out.println(smallestMultiple.searchSmallesMultiple());

    }

    public int searchSmallesMultiple() {
        boolean play = true;
        int i = 2520;
        while (play) {
            i++;
            if ((i % 20 == 0 && i % 19 == 0 && i % 18 == 0 && i % 17 == 0 && i % 16 == 0 && i % 14 == 0 && i % 13 == 0 && i % 11 == 0)) {
                play = false;
            }
        }
        return i;
    }


}
