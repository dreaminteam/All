package singleton;

/**
 * Created by dreaminteam on 6.7.15.
 */
public class SingletonBillPugh {

    private SingletonBillPugh() {
    }


    private static class SingletonHolder {

        private static SingletonBillPugh instance = new SingletonBillPugh();

    }

    public static SingletonBillPugh getInstance() {
        return SingletonHolder.instance;
    }

}
