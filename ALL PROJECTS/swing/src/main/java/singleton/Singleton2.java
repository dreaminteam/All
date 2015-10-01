package singleton;

/**
 * Created by dreaminteam on 6.7.15.
 */
public class Singleton2 {

    private static Singleton2 instance=new Singleton2();

    private Singleton2(){

    };

    public static Singleton2 getInstance(){
        return instance;
    }
}
