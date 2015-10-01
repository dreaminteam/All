package CollectTest;

import java.util.*;

/**
 * Created by dreaminteam on 4.8.14.
 */
public class CollectTest {

    public static void main(String[] args) {
        Collection<String> list=new ArrayList<String>();
        list.add("Hanry");
        list.add("Garry");
        list.add("Piter");
        list.add("Anna");

        Iterator iter= list.iterator();
        while (iter.hasNext()){
            iter.next();
            if (iter.hasNext()){
                iter.next();
                iter.remove();
            }
        }

        if (iter.hasNext()) {
            iter.next();
            list.add("Max");
        }
        list.add("Lina");

        System.out.println("list="+list.toString());

        Collection<String> list2=new ArrayList<String>();
        list2.add("1");
        list2.add("2");
        list2.add("3");
        System.out.println("list2="+list2.toString());
        System.out.println(list2.contains("22"));

        Iterator iter2=list2.iterator();
        list.addAll(list2);
        System.out.println(list.toString());

        List<String> staff=new LinkedList<String>();
        staff.add("Amy");
        staff.add("Bob");
        staff.add("Carl");
        ListIterator<String> iter3=staff.listIterator();
        iter3.next();
        iter3.add("Juliet");
        System.out.println(staff.get(1));
        System.out.println(staff.toString());
    }


}


