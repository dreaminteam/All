package SetTest;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * Created by dreaminteam on 4.8.14.
 */
public class SetTest {

    public static void main(String... args) throws FileNotFoundException{

        Set<String> words=new HashSet<String>();
        String putch="/home/dreaminteam/Загрузки/Garri_Potter_i_Dary_smerti.txt";
        Scanner in=new Scanner(new File(putch));
        long totalTime=0;
        while (in.hasNext()){
            String word=in.next();
            long callTime=System.currentTimeMillis();
            words.add(word);
            callTime=System.currentTimeMillis()-callTime;
            totalTime+=callTime;
        }
        Iterator<String> iter=words.iterator();

        System.out.println("...");
        System.out.println(words.size()+" уникальных слов");
        System.out.println(totalTime+" миллисекунд");

        SortedSet<String> words2=new TreeSet<String>();
        long totalTime2=0;
        while (in.hasNext()){
            String word=in.next();
            long callTime2=System.currentTimeMillis();
            words.add(word);
            callTime2=System.currentTimeMillis()-callTime2;
            totalTime+=callTime2;
        }
        Iterator<String> iter2=words2.iterator();

        System.out.println("...");
        System.out.println(words.size()+" уникальных слов");
        System.out.println(totalTime+" миллисекунд");
    }
}
