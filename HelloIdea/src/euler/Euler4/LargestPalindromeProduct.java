package euler.Euler4;

import euler.Euler1.Euler3.LargestPrimeFactor;

/**
 * Created by dreaminteam on 10.10.14.
 */
public class LargestPalindromeProduct {

    public static void main(String[] args) {

        LargestPalindromeProduct palindromeProduct = new LargestPalindromeProduct();
        System.out.println(palindromeProduct.searchPalindrome());

    }

    public int searchPalindrome() {

        int interim = 10000;
        int result = interim;
        int border = 99;
        int i = 999;
        while (i > border) {
            for (int j = i; j > border; j--) {
                interim = i * j;
                if (checkPolindrom(interim)) {
                    border = j;
                    if (result < interim) {
                        result = interim;
                    }
                    break;
                }
            }

            i--;
        }
        return result;
    }

    public boolean checkPolindrom(int number) {

        String numString = String.valueOf(number);
        for (int i = 0; i <= (numString.length() / 2) - 1; i++) {
            if (numString.charAt(i) != numString.charAt(numString.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }

}
