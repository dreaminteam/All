package singleton;

/**
 * Created by dreaminteam on 6.7.15.
 */
public class SingletonSynh {

    private static SingletonSynh instance;

    private SingletonSynh() {

    }

    public static synchronized SingletonSynh getInstance() {
        if (instance == null) {
            instance = new SingletonSynh();
        }
        return instance;
    }
}
