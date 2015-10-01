package dreaminteam;

/**
 * Created by dreaminteam on 31.3.15.
 */

import com.sun.org.apache.bcel.internal.util.ClassPath;
//import org.h2.tools.RunScript;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;

public class JDBCExample {


    public static void main(String[] args) throws IOException {

        LibraryGetPropertyValues getPropertyValues = new LibraryGetPropertyValues();
        String user = getPropertyValues.getPropValues("user");//Login of user
        String password = getPropertyValues.getPropValues("password");//Password of user
        String url = getPropertyValues.getPropValues("url");
        String driver = getPropertyValues.getPropValues("driver");//Name of driver

        try {
            //driver registration
            //Class.forName(driver);
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        Connection c = null;//compound with data base
        try {



            PreparedStatement psql;
            ResultSet rset;
            c = DriverManager.getConnection(url, user, password);//connection to data басе

            psql = c.prepareStatement("insert into customer values(?,?)");//make request

            // st.execute("create table customer(id integer, name varchar(10))");
            // st.execute("delete from customer");
            //psql.setInt(1,4);
            //psql.setString(2,"DAN1L");
            //int t=psql.executeUpdate();
            Statement stmt = c.createStatement();
            rset = stmt.executeQuery("select name from Books");
            while (rset.next()) {
                String name = rset.getString(1);
                System.out.println(name);

            }
           /*
            ResultSet rs = st.executeQuery("select * from Authors");//Выполняем запрос к БД, результат в переменной rs
            while(rs.next()){
              System.out.println(rs.getString(2)+" "+rs.getString(3));//Последовательно для каждой строки выводим значение из колонки ColumnName

            }
            */
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //Обязательно необходимо закрыть соединение
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
