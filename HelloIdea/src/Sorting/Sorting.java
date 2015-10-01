package Sorting;

import java.util.Arrays;

/**
 * Created by dreaminteam on 16.9.14.
 */
public class Sorting {

    public static void main(String... args) {

        Sorting sorting = new Sorting();
        int[] array = {2, 1, 8, 5, 9, 4, 6};
        int[] arr2 = {8, 6, 4, 2, 0, 1};
        //    sorting.sortingBubblesToLow(array);
        //    sorting.sortingBubblesToLow(arr2);
        //    System.out.println(Arrays.toString(array));
        //    System.out.println(Arrays.toString(arr2));
        //    System.out.println(Arrays.toString(sorting.mergeToLow(array, arr2)));
        // sorting.sortingBubblesToLow(array);
        // System.out.println(Arrays.toString(array));

        //sorting.sortHighRecursion(array, 0, array.length - 1);
        System.out.println(Arrays.toString(array));


    }

    public int[] sortingBubblesToHigh(int[] array) {

        int length = array.length;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    transposition(array, j, j + 1);
                }
            }
        }
        return array;
    }

    public int[] sortingBubblesToLow(int[] array) {

        int length = array.length;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length - i - 1; j++) {
                if (array[j] < array[j + 1]) {
                    transposition(array, j, j + 1);
                }
            }
        }
        return array;
    }

    public int[] mergeToHigh(int[] arrayA, int[] arrayB) {

        int[] arrayC = new int[arrayA.length + arrayB.length];

        int a = 0;
        int b = 0;
        for (int i = 0; i < arrayC.length; i++) {
            if (a < arrayA.length && b < arrayB.length) {
                if (arrayA[a] < arrayB[b]) {
                    arrayC[i] = arrayA[a++];
                } else {
                    arrayC[i] = arrayB[b++];
                }
            } else {
                if (a > arrayA.length | a == arrayA.length) {
                    arrayC[i] = arrayB[b++];
                } else {
                    arrayC[i] = arrayA[a++];
                }
            }
        }

        return arrayC;
    }

    public int[] mergeToLow(int[] arrayA, int[] arrayB) {

        int[] arrayC = new int[arrayA.length + arrayB.length];

        int a = 0;
        int b = 0;
        for (int i = 0; i < arrayC.length; i++) {
            if (a < arrayA.length && b < arrayB.length) {
                if (arrayA[a] > arrayB[b]) {
                    arrayC[i] = arrayA[a++];
                } else {
                    arrayC[i] = arrayB[b++];
                }
            } else {
                if (a > arrayA.length | a == arrayA.length) {
                    arrayC[i] = arrayB[b++];
                } else {
                    arrayC[i] = arrayA[a++];
                }
            }
        }

        return arrayC;
    }

/*    public int[] sortHighRecursion(int[] array, int from, int to) {

        if (Math.abs(from - to) < 2) {
            return array;
        } else {
            if (Math.abs(from - to) == 2) {
                if (array[from] > array[to]) {
                    transposition(array, from, to);
                    return array;
                }
            }
            int[] a = new int[array.length / 2];
            int[] b = new int[array.length - array.length / 2];
            for (int i = 0; i < array.length / 2; i++) {
                a[i] = array[i];
            }
            for (int i = Math.round(array.length / 2); i < array.length; i++) {
                b[i] = array[i];
            }
            return mergeToHigh(sortHighRecursion(a))

        }

    }
*/
    public void transposition(int[] array, int a, int b) {

        int c = array[a];
        array[a] = array[b];
        array[b] = c;
    }


}
