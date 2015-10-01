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
public class DataBooks {
/*
    public Map init(String path) {

        Map<Integer, Book> map = new HashMap();
        StringBuilder strB = new StringBuilder();

        try {
            Scanner scan = new Scanner(new File(path));
            while (scan.hasNext()) {
                String[] str = scan.nextLine().split(";");
                for (int j = 3; j < str.length; j++) {
                    strB.append(str[j]);
                }
                map.put(Book.index, new Book(str[0], Integer.valueOf(str[1]),str[3], String.valueOf(strB)));
                strB.delete(0, strB.length());

            }
        }
        catch (FileNotFoundException exp1){
            exp1.getMessage();
            System.out.println("Завершение программы");
            System.exit(0);
        }
        catch (ArrayIndexOutOfBoundsException exp2){
            exp2.getMessage();
            System.out.println("Завершение программы");
            // System.exit(0);
        }
        data=map;
        return data;
    }

    public void write(String fileName,Map<Integer,Book> dataMap) {
        try {
            PrintWriter out = new PrintWriter(new File(fileName).getAbsoluteFile());
            try {
                for (Book item : dataMap.values()){
                    out.println(item.toWrite());
                }
            } finally {
                out.close();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void print(Map<Integer,Book> map){
        for (Map.Entry<Integer,Book> entry:map.entrySet()){
            Integer key=entry.getKey();
            Book value=entry.getValue();
            System.out.println("key="+key+" ; Book: "+value.toString());
        }
    }

    public Map<Integer,Book> data=new HashMap<Integer, Book>();
*/
}
