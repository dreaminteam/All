package singleton;

/**
 * Created by dreaminteam on 6.7.15.
 */
public class SingletonVol {

    private static volatile SingletonVol instance;

    private SingletonVol() {

    }

    public static SingletonVol getInstance() {
        if (instance == null) {
            synchronized (SingletonVol.class) {
                if (instance == null) {
                    instance = new SingletonVol();
                }
            }
        }
        return instance;
    }
}
