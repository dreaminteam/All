package euler.euler19.CountingSundays;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Admin on 18.08.14.
 */
public class CountingSundays {

    public static void main(String[] args) {
        new CountingSundays().sandeyFirstDay(2001);
        System.out.println(numSun);
    }

    public void sandeyFirstDay(int yearLimit) {
        int residue = 7;
        while (year < yearLimit) {
            days();
            for (int i = 1; i < 12; i++) {
                residue = (mapMonths.get(i) - (7 - residue)) % 7;
                if ((residue + 1) % 7 == 0) {
                    numSun++;
                }
            }
            if (!((year + 1) == yearLimit)) {
                residue = (mapMonths.get(12) - (7 - residue)) % 7;
                if ((residue + 1) % 7 == 0) {
                    numSun++;
                }
            }
            year++;
        }
    }

    public static void days() {
        if (year % 100 == 0) {
            if (year % 400 == 0) {
                mapMonths.put(2, 29);
            }
        } else {
            if (year % 4 == 0) {
                mapMonths.put(2, 29);
            } else {
                mapMonths.put(2, 28);
            }
        }
    }

    private static int year = 1900;
    private static int numSun = 0;
    private static Map<Integer, Integer> mapMonths = new HashMap(12);

    static {
        mapMonths.put(1, 31);
        mapMonths.put(2, 28);
        mapMonths.put(3, 31);
        mapMonths.put(4, 30);
        mapMonths.put(5, 31);
        mapMonths.put(6, 30);
        mapMonths.put(7, 31);
        mapMonths.put(8, 31);
        mapMonths.put(9, 30);
        mapMonths.put(10, 31);
        mapMonths.put(11, 30);
        mapMonths.put(12, 31);
    }
}
