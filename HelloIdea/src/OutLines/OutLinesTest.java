package OutLines;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * @version 1.8
 * @author Andrej Zenov
 * derivation element from the list with the number of repetitions of each
 */
public class OutLinesTest {

    public Set<ListRepetitions> inicList(String path) throws FileNotFoundException{
        Set<ListRepetitions> mySet=new LinkedHashSet<ListRepetitions>();
        Scanner scanner=new Scanner(new File(path));
        ListRepetitions buf;
        while (scanner.hasNext()) {
            buf = new ListRepetitions(scanner.next(), 1);
            if (!mySet.add(buf))
                {
                for (ListRepetitions lr : mySet) {
                    if (lr.equals(buf)) {
                        lr.setNumber();
                    }
                }
            } else mySet.add(buf);
        }
        return mySet;
    }

    public static void main(String[] args) throws FileNotFoundException{
        String p="/home/dreaminteam/IdeaProjects/HelloIdea/src/OutLines/list.txt";
        OutLinesTest outL = new OutLinesTest();
        Set <ListRepetitions> list=outL.inicList(p);
        for (ListRepetitions ln:list){
            System.out.println(ln.toString());
        }
    }
}

class ListRepetitions{

    public ListRepetitions(String l,int n){
        list=l;
        number=n;
    }

    public String getList(){
        return list;
    }

    public int getNumber(){
        return number;
    }

    public void setNumber(){
        number++;
    }

    @Override public boolean equals(Object otherObject){

        if (this==otherObject) return true;

        if (otherObject==null) return false;

        if (getClass()!=otherObject.getClass()) return false;

        ListRepetitions other=(ListRepetitions)otherObject;

        return list.equals(other.list);
    }

    @Override public int hashCode(){
        return 7*list.hashCode();
    }

    @Override public String toString(){
        return "["+getList()+"-repetition "+number+"]";
    }

    private String list;
    private int number;
}
