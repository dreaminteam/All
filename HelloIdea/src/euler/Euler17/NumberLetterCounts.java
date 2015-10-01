package euler.Euler17;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by dreaminteam on 14.10.14.
 *
 * Счет букв в числительных
 * Сколько букв понадобится для записи всех чисел от 1 до 1000 (one thousand) включительно?
 * в отображении чисел игнорируются правила британского английского.
 * Для того чтобы образовать числительные от 20 до 99 используем такой же принцип, как и в русском языке,
 * сначала – десятки, потом – единицы.Единственное, на что следует обратить внимание – числительные, состоящие из двух цифр,
 * первая из которых обозначает десятки, пишутся в английском языке через дефис.
 * Перед десятками (в британском варианте английского языка) необходимо добавлять союз and
 * (даже когда десятки обозначены нулём: 108 = a hundred and eight).
 * Также не забываем ставить дефис между десятками и единицами.
 */
public class NumberLetterCounts {

    public static void main(String[] args) {

        NumberLetterCounts nlc = new NumberLetterCounts();
        StringBuffer result = new StringBuffer();
        for (int i = 1; i <= 1000; i++) {
            String str = nlc.numberOfWords(i);
        //    System.out.print(str + " ");
            result.append(str);
        }
        System.out.println("letter " + result.toString().length());
        //  System.out.println(nlc.numberOfWords(4000));

    }

    /*
    Возвращает буквенный эквивалент числа (провила написания игнорируются для данной задачи)
     */
    public String numberOfWords(int number) {

        if (number > 0 && number <= 20) {
            return from1To20.get(number);
        }

        StringBuffer words = new StringBuffer();

        int thousands = number / 1000;

        if (thousands > 0) {
            words.append(from1To20.get(thousands) + "thousand");
            number = number % 1000;
            if (number == 0) {
                return words.toString();
            }
        }

        int hundreds = number / 100;
        int resHund = number % 100;
        int tens = resHund / 10;
        int unit = resHund % 10;

        if (hundreds > 0) {
            words.append(from1To20.get(hundreds) + "hundred");

            if (resHund == 0) {
                return words.toString();
            } else {
                words.append("and");
            }
        }

        if (resHund <= 20) {
            words.append(from1To20.get(resHund));
            return words.toString();
        } else {
            if (tens == 0) {
                words.append(from1To20.get(unit));
                return words.toString();
            }
        }

        words.append(onTens.get(tens) + from1To20.get(unit));
        return words.toString();
    }


    public static Map<Integer, String> from1To20 = new HashMap<>(20);
    public static Map<Integer, String> onTens = new HashMap<>(8);

    static {
        from1To20.put(0,"");
        from1To20.put(1, "one");
        from1To20.put(2, "two");
        from1To20.put(3, "three");
        from1To20.put(4, "four");
        from1To20.put(5, "five");
        from1To20.put(6, "six");
        from1To20.put(7, "seven");
        from1To20.put(8, "eight");
        from1To20.put(9, "nine");
        from1To20.put(10, "ten");
        from1To20.put(11, "eleven");
        from1To20.put(12, "twelve");
        from1To20.put(13, "thirteen");
        from1To20.put(14, "fourteen");
        from1To20.put(15, "fifteen");
        from1To20.put(16, "sixteen");
        from1To20.put(17, "seventeen");
        from1To20.put(18, "eighteen");
        from1To20.put(19, "nineteen");
        from1To20.put(20, "twenty");

        onTens.put(2, "twenty");
        onTens.put(3, "thirty");
        onTens.put(4, "forty");
        onTens.put(5, "fifty");
        onTens.put(6, "sixty");
        onTens.put(7, "seventy");
        onTens.put(8, "eighty");
        onTens.put(9, "ninety");


    }


}
