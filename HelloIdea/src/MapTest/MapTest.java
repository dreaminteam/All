package MapTest;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * Created by dreaminteam on 7.8.14.
 */
public class MapTest {

    public static void main(String[] args) {

        Map<String,Employee> staff=new HashMap<String, Employee>();
        Map<String,Employee> trStaff=new TreeMap<String, Employee>();

        staff.put("1987",new Employee("Andro"));
        staff.put("1989",new Employee("Dmitry"));
        staff.put("1962",new Employee("Fiodor"));
        staff.put("1965", new Employee("Galia"));

        trStaff.put("1987",new Employee("Andro"));
        trStaff.put("1989",new Employee("Dmitry"));
        trStaff.put("1962",new Employee("Fiodor"));
        trStaff.put("1965", new Employee("Galia"));

     /*   Employee e=staff.put("1965",new Employee("Nina"));// put возвращает предыдущее значение для этого ключа или null,если ключ не найден

        System.out.println(e.getName());
     */

     /*   Set<String> keys=staff.keySet();//набор ключей
        System.out.println(keys);
        System.out.println(staff.containsKey("1963"));//ищет есть ли такой ключ
     */

        System.out.println(staff);
        System.out.println(trStaff);

        System.out.println(staff.remove("1989"));
        System.out.println(trStaff.remove("1989"));

        staff.put("2013",new Employee("Nikitos"));
        System.out.println(staff);

        System.out.println(staff.get("1962"));

        for (Map.Entry<String,Employee> entry:staff.entrySet()){
            String key=entry.getKey();
            Employee value=entry.getValue();
            System.out.println("key="+key+", value="+value);
        }

    }
}

class Employee{

    public Employee(String name){
        this.name=name;
        salary=0;
    }
    @Override
    public String toString(){
        return "[name "+name+", salary="+salary+"]";
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    private String name;
    private double salary;
}
