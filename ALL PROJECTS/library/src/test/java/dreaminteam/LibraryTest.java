package dreaminteam;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by dreaminteam on 28.5.15.
 */
public class LibraryTest {

    Connection connection=null;

    QueryTableBooks queryTableBooks=new QueryTableBooks();
    @Before
    public void Init() throws IOException {
        LibraryGetPropertyValues getPropertyValues=new LibraryGetPropertyValues();
        String user = getPropertyValues.getPropValues("user");//Login of user
        String password = getPropertyValues.getPropValues("password");//Password of user
        String url = getPropertyValues.getPropValues("url");
        String driver = getPropertyValues.getPropValues("driver");//Name of driver
        Connection conn=null;
        try{
            Class.forName(driver);
        } catch (ClassNotFoundException e){
            e.printStackTrace();
        }

        try {
            conn= DriverManager.getConnection(url,user,password);
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            try {
                if (conn!=null){
                    conn.close();
                }
            } catch (SQLException e){
                e.printStackTrace();
            }
        }
        connection=conn;
    }


    @Test
    public void allBooks() throws IOException, SQLException {
        queryTableBooks.selectAllBooks(connection);
    }
}
