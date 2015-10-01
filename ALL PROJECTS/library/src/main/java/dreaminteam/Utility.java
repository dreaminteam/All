package dreaminteam;

import java.sql.*;

/**
 * Created by dreaminteam on 27.5.15.
 */
public class Utility {


    public void connection(String url, String user, String password, String driver) {

        try {
            //driver registration
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        Connection c = null;//compound with data base
        try {
            c = DriverManager.getConnection(url, user, password);//connection to data басе
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //Look out! Close connection
            try {
                if (c != null)
                    c.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }


}
