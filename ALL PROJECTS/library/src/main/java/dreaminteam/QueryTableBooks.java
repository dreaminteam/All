package dreaminteam;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by dreaminteam on 27.5.15.
 */
public class QueryTableBooks {

    public void selectAllBooks(Connection connection) throws SQLException {
        PreparedStatement preparedStatement=connection.prepareStatement("select * from Books");
        ResultSet resultSet=preparedStatement.executeQuery();
    }

    public void selectBooksOfAuthor(Connection connection,String author) throws SQLException {
        PreparedStatement preparedStatement=connection.prepareStatement("Select name,genre,year_publication from Books" +
                " where id IN (select idBook from AB join Authors ON idAuthor=id where first_name or surname LIKE '%"+author+"%' )" );
    }
}
