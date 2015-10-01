package librarian;

/**
 * Created by dreaminteam on 19.12.14.
 */
public class AuthorsOfBooks {

    public int authorID;
    public int bookID;

    @Override
    public String toString(){
        return "authorID : "+authorID+" - "+bookID+" : bookID";
    }

}
