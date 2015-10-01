package dit.dreaminteam.json.books;

import dit.dreaminteam.entities.Book;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by dreaminteam on 19.2.15.
 */
public class ParserJson {

    public static void main(String[] args) throws IOException, JSONException {

        ParserJson parserJson = new ParserJson();
        List<Book> books = parserJson.parsJson("db/booksOut.json");
        System.out.println(books.toString());
    }


    public List<Book> parsJson(String pathToFileBooksJson) throws IOException, JSONException {

        List<Book> listBooks = new ArrayList<Book>();

        ClassLoader classLoader = getClass().getClassLoader();

        try (InputStream inputStream = classLoader.getResourceAsStream(pathToFileBooksJson)) {

            JSONTokener tokener = new JSONTokener(inputStream);
            JSONObject jsonObject = new JSONObject(tokener);
            JSONArray jsonArray = jsonObject.getJSONArray("books");

            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject object = jsonArray.getJSONObject(i);
                Book book = new Book();
                book.name = object.getString("name");
                book.availability = object.getBoolean("availability");
                book.genre = object.getString("genre");
                book.id = object.getInt("id");
                book.yearOfPublication = object.getInt("publication");
                //book.authors = object.getString("authors");
                listBooks.add(book);
            }
        }
        return listBooks;
    }
}
