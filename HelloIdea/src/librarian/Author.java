package librarian;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by dreaminteam on 2.10.14.
 */
public class Author {

    public Author(){
    }

    public Author(String ownName, String surName, String dateOfBirth) {
        this.ownName = ownName;
        this.surName = surName;
        this.dateOfBirth = dateOfBirth;
    }

    @Override
    public String toString(){
        return "id:"+id+" Name:"+ownName+" "+surName+"; date of Birth:"+dateOfBirth;
    }

    public String ownName;
    public String surName;
    public String dateOfBirth;
    public String id;

}
