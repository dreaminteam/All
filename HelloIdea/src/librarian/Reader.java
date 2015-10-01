package librarian;

/**
 * Created by dreaminteam on 3.9.14.
 */
public class Reader {

    public Reader(String ownName, String surName, String passport, String address, String phone) {
        this.passport = passport;
        this.ownName = ownName;
        this.surName = surName;
        this.address = address;
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "[id=" + getId() + "-Name:" + ownName + " " + surName +
                "; Passport:" + passport + "; Address:" + address + "; phone:" + phone + "]";
    }

    public String toWrite(){
        return ownName+";"+surName+";"+passport+";"+address+";"+phone;
    }

    public int getId() {
        return id;
    }

    public String ownName;
    public String surName;
    public String passport;
    public String address;
    public String phone;
    private int id = index++;

    public static int index = 0;
}
