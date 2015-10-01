package librarian;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by dreaminteam on 3.9.14.
 */
public class Book {

    @Override
    public String toString() {
        return "id:" + id + " - Name:" + name + "; genre:" + genre +
                "; authors:" + "; availability:" + availability;
    }

    public String id;
    public String genre;
    public String name;
    public int yearOfPublication;
    public String availability;
}
