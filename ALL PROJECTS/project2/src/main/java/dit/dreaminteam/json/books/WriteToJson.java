package dit.dreaminteam.json.books;

import dit.dreaminteam.entities.Book;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * Created by dreaminteam on 26.2.15.
 */
public class WriteToJson {

    public static void main(String[] args) throws IOException, JSONException {

        WriteToJson writeToJson = new WriteToJson();
        ParserJson parserJson = new ParserJson();
        List<Book> list = parserJson.parsJson("db/booksOut.json");
        writeToJson.toJson(list, "db/books.json");
    }


    public void toJson(List booksList, String puthOutJsonBooks) throws IOException, JSONException {

        JSONArray arrayBooks = new JSONArray();
        JSONObject books = new JSONObject();

        List<Book> list = booksList;

        for (Book b : list) {
            JSONObject jsonBook = new JSONObject();
            jsonBook.put("id", b.id);
            jsonBook.put("name", b.name);
            jsonBook.put("genre", b.genre);
            jsonBook.put("publication", b.yearOfPublication);
            jsonBook.put("availability", b.availability);
            arrayBooks.put(jsonBook);
        }
        books.put("books", arrayBooks);

        /*
        String path = "/home/dreaminteam/ALL PROJECTS/project2/src/main/resourсes/db/books.json";
        String base = "/home/dreaminteam/ALL PROJECTS/project2";
        String relative = new File(base).toURI().relativize(new File(path).toURI()).getPath();
        System.out.println(relative);
        */

        try (PrintWriter out = new PrintWriter(new File("src/main/resourсes/" + puthOutJsonBooks))) {
            out.print(books);
        }
    }
}
