package Interface;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dreaminteam on 31.7.14.
 */
public class InterfaceTest {

    public static void main(String[] args)  throws  CloneNotSupportedException{

        List<KickAction> list=new ArrayList<KickAction>();
        list.add(new SumoFighter());
        list.add(new Boxer());
        list.add(new KickBoxer());
        list.add(new Boxer());

        for (KickAction e:list){
            System.out.println(e.punch());
        }
    }
}

class SumoFighter implements KickAction {

    @Override
    public String punch(){
        return new String("Thick");
    }
}

class Boxer implements KickAction {

    public String punch() {
        return new String("Hand");
    }
}

class KickBoxer implements KickAction {

    public String punch() {
        return new String("Kick");
    }
}
