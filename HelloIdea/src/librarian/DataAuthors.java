package librarian;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by dreaminteam on 2.10.14.
 */
public class DataAuthors {
/*
    public Map init(String path) {

        Map<Integer, Author> map = new HashMap();

        try {
            Scanner scan = new Scanner(new File(path));
            while (scan.hasNext()) {
                String[] str = scan.nextLine().split(";");
                map.put(Author.index, new Author(str[0], str[1],str[2]));
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

    public void write(String fileName,Map<Integer,Author> dataMap) {
        try {
            PrintWriter out = new PrintWriter(new File(fileName).getAbsoluteFile());
            try {
                for (Author item : dataMap.values()){
                    out.println(item.toWrite());
                }
            } finally {
                out.close();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void print(Map<Integer,Author> map){
        for (Map.Entry<Integer,Author> entry:map.entrySet()){
            Integer key=entry.getKey();
            Author value=entry.getValue();
            System.out.println("key="+key+" ; Author: "+value.toString());
        }
    }

    public Map<Integer,Author> data=new HashMap<Integer, Author>();

*/
}
