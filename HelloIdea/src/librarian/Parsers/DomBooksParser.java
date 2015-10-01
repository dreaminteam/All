package librarian.Parsers;

import librarian.Book;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by dreaminteam on 19.12.14.
 */
public class DomBooksParser {

    public static void main(String[] args) throws Exception {

        DomBooksParser domBooksParser=new DomBooksParser();
        ArrayList<Book> books=(ArrayList)domBooksParser.booksParser(
                "/home/dreaminteam/IdeaProjects/HelloIdea/src/librarian/xml/books.xml");
        for (Book book:books){
            System.out.println(book.toString());
        }
    }

    public List booksParser(String path) throws ParserConfigurationException, IOException, SAXException {

        List<Book> booksList = new ArrayList<>();

        //Get the DOM Builder Factory
        DocumentBuilderFactory factory =
                DocumentBuilderFactory.newInstance();

        //Get the DOM Builder
        DocumentBuilder builder = factory.newDocumentBuilder();

        //Load and Parse the XML document
        //document contains the complete XML as a Tree.
        Document document =
                builder.parse(
                        new File(path));

        //Iterating through the nodes and extracting the data.
        NodeList nodeList = document.getDocumentElement().getChildNodes();

        for (int i = 0; i < nodeList.getLength(); i++) {

            //We have encountered an <employee> tag.
            Node node = nodeList.item(i);
            if (node instanceof Element) {
                Book book = new Book();
                book.id = node.getAttributes().
                        getNamedItem("id").getNodeValue();
                book.availability = node.getAttributes().
                        getNamedItem("availability").getNodeValue();

                NodeList childNodes = node.getChildNodes();
                for (int j = 0; j < childNodes.getLength(); j++) {
                    Node cNode = childNodes.item(j);

                    //Identifying the child tag of employee encountered.
                    if (cNode instanceof Element) {
                        String content = cNode.getLastChild().
                                getTextContent().trim();
                        switch (cNode.getNodeName()) {
                            case "name":
                                book.name = content;
                                break;
                            case "yearOfPublication":
                                book.yearOfPublication = Integer.valueOf(content);
                                break;
                            case "genre":
                                book.genre = content;
                                break;
                        }
                    }
                }
                booksList.add(book);
            }
        }
        return booksList;
    }
}