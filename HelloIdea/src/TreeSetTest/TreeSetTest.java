package TreeSetTest;

import java.util.Comparator;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * Created by dreaminteam on 4.8.14.
 */
public class TreeSetTest {

    public static void main(String[] args) {

        SortedSet<Item> parts=new TreeSet<Item>();
        parts.add(new Item("Toaster",1234));
        parts.add(new Item("Modem",9912));
        parts.add(new Item("Widget",4562));

        System.out.println(parts.toString());

        SortedSet<Item> sortedByDescreption=new TreeSet<Item>(new Comparator<Item>() {
            @Override
            public int compare(Item a, Item b) {
                String dscrA=a.getDiscription();
                String dscrB=b.getDiscription();
                return dscrA.compareTo(dscrB);
            }
        });
        sortedByDescreption.addAll(parts);
        System.out.println(sortedByDescreption);
        System.out.println(parts.first()+"  -  "+sortedByDescreption.first());
        System.out.println(parts.last()+"  -  "+sortedByDescreption.last());
    }

}

class Item implements Comparable<Item>{

    public Item(String description, int partNumber){
        this.description=description;
        this.partNumber=partNumber;
    }

    public String getDiscription(){
        return description;
    }

    public int getPartNumber(){
        return partNumber;
    }

    @Override
    public boolean equals(Object otherObject){
        if (this==otherObject) return true;
        if (otherObject==null) return false;
        if (getClass()!=otherObject.getClass()) return false;
        Item other=(Item)otherObject;
        if ((description.equals(other.description))
            && partNumber==other.partNumber) return true;
        return false;

    }

    @Override
    public int hashCode(){
        return 13*description.hashCode()+7*partNumber;
    }

    @Override
    public int compareTo(Item other){
        return partNumber-other.partNumber;
    }

    @Override
    public String toString(){
        return "[discription="+description+", PartNumber="+partNumber+"]";
    }

    private String description;
    private int partNumber;
}
