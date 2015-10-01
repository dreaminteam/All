package euler.Euler18;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by dreaminteam on 15.10.14.
 */
public class MaximumPathSum {

    public static void main(String[] args) throws FileNotFoundException {

        String pathEuler16 = "/home/dreaminteam/IdeaProjects/HelloIdea/src/euler/Euler18/data.txt";
        String pathEuler67 = "/home/dreaminteam/IdeaProjects/HelloIdea/src/euler/Euler18/p067_triangle.txt";

        MaximumPathSum mps = new MaximumPathSum();

        ArrayList<int[]> triangleEuler16 = mps.initTriangle(pathEuler16);
        ArrayList<int[]> triangleEuler67 = mps.initTriangle(pathEuler67);

        ArrayList<int[]> resultEuler16 = mps.maximumPath(triangleEuler16);
        ArrayList<int[]> resultEuler67 = mps.maximumPath(triangleEuler67);

        /*
        System.out.println(mps.print(triangleEuler16));
        System.out.println(mps.print(triangleEuler67));
        */

        System.out.println("Answer Task Euler16: " + mps.maxInArray(resultEuler16.get(resultEuler16.size() - 1)));
        System.out.println("Answer Task Euler67: " + mps.maxInArray(resultEuler67.get(resultEuler67.size() - 1)));

    }

    /*
    Возвращает наибольший элемент массива int
     */
    public int maxInArray(int[] array) {
        int max = 0;
        for (int e : array) {
            if (e > max) {
                max = e;
            }
        }
        return max;
    }


    public ArrayList<int[]> maximumPath(ArrayList<int[]> arrayTriangle) {

        ArrayList<int[]> result = new ArrayList<>(arrayTriangle.size());
        result.add(arrayTriangle.get(0));

        for (int i = 1; i < arrayTriangle.size(); i++) {
            int[] arr = new int[arrayTriangle.get(i).length];
            arr = outArrayMaxRouter(arrayTriangle.get(i), result.get(i - 1));
            result.add(arr);
        }
        return result;
    }

    /*
    Инитиализация треугольника
    Возвращает список массивов треугольника из файла, путь к которому указан в парамерте
     */
    public ArrayList<int[]> initTriangle(String path) throws FileNotFoundException {

        ArrayList<int[]> result = new ArrayList<>();
        Scanner scan = new Scanner(new File(path));
        while (scan.hasNext()) {
            String[] str = scan.nextLine().split(" ");
            int[] buff = new int[str.length];
            int k = 0;
            for (String s : str) {
                buff[k] = Integer.valueOf(s);
                k++;
            }
            result.add(buff);
        }
        return result;
    }

    /*
    Генерирует массив с максимальной стоимостью маршрута
     */
    public int[] outArrayMaxRouter(int[] readTriangle, int[] maximumRoutes) {

        int length = readTriangle.length;
        int[] result = new int[length];
        result[0] = readTriangle[0] + maximumRoutes[0];
        if (length > 1) {
            result[length - 1] = readTriangle[length - 1] + maximumRoutes[length - 2];
        }
        for (int i = 1; i < result.length - 1; i++) {
            result[i] = Math.max(maximumRoutes[i - 1], maximumRoutes[i]) + readTriangle[i];
        }
        return result;
    }


    public String print(ArrayList<int[]> array) {
        String result = "";
        for (int[] e : array) {
            for (int i : e) {
                result += (i + " ");
            }
        }
        return result;
    }
}
