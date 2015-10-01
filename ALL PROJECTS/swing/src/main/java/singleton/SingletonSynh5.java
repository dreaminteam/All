package singleton;

/**
 * Created by dreaminteam on 6.7.15.
 */
public class SingletonSynh5 {

    private static SingletonSynh5 instance;

    private SingletonSynh5() {

    }

    public static SingletonSynh5 getInstance() {

        SingletonSynh5 localInstance = instance;
        if (localInstance == null) {
            synchronized (SingletonSynh5.class) {
                localInstance = instance;
                if (localInstance == null) {
                    localInstance = instance = new SingletonSynh5();
                }
            }
        }
        return localInstance;
    }
}
