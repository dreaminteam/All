package dit.dreaminteam.entities;

/**
 * Created by dreaminteam on 6.2.15.
 */
public class Book {

    @Override
    public String toString() {
        return "id:" + id + " - Name:" + name + "; y.p.:"+yearOfPublication+ "; genre:" + genre +
                "; authors:" + authors+ "; availability:" + availability;
    }

    public int id;
    public String genre;
    public String name;
    public String authors;
    public int yearOfPublication;
    public boolean availability;
}
