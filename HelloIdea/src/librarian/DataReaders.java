package librarian;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by dreaminteam on 18.9.14.
 */
public class DataReaders {

    public Map init(String path) {

        Map<Integer, Reader> map = new HashMap();

        try {
            Scanner scan = new Scanner(new File(path));
            while (scan.hasNext()) {
                String[] str = scan.nextLine().split(";");
                map.put(Reader.index, new Reader(str[0], str[1], str[2], str[3], str[4]));
            }
        } catch (FileNotFoundException exp1) {
            exp1.getMessage();
            System.out.println("Завершение программы");
            System.exit(0);
        } catch (ArrayIndexOutOfBoundsException exp2) {
            exp2.getMessage();
            System.out.println("Завершение программы");
            // System.exit(0);
        }
        data = map;
        return data;
    }

    public void write(String fileName,Map<Integer,Reader> dataMap) {
        try {
            PrintWriter out = new PrintWriter(new File(fileName).getAbsoluteFile());
            try {
                for (Reader item : dataMap.values()){
                    out.println(item.toWrite());
                }
            } finally {
                out.close();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void print(Map<Integer,Reader> map) {

        for (Map.Entry<Integer, Reader> entry : map.entrySet()) {
            Integer key = entry.getKey();
            Reader value = entry.getValue();
            System.out.println("key=" + key + " : Reader" + value.toString());
        }
    }

    public Map<Integer, Reader> data = new HashMap<Integer, Reader>();

}
