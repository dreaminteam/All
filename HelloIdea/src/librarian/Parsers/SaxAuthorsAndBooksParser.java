package librarian.Parsers;

import librarian.AuthorsOfBooks;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.*;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.util.ArrayList;

/**
 * Created by dreaminteam on 19.12.14.
 */
public class SaxAuthorsAndBooksParser {

    public static void main(String[] args) throws Exception {
        SAXParserFactory parserFactor = SAXParserFactory.newInstance();
        SAXParser parser = parserFactor.newSAXParser();
        SAXHandler handler = new SAXHandler();
        parser.parse(new File("..xml/authorsAndBooks.xml"),
                handler);
        //Printing the list of employees obtained from XML
        for (AuthorsOfBooks emp : handler.getAuthorsOfBooks()) {
            System.out.println(emp.toString());
        }
    }

    static class SAXHandler extends DefaultHandler {

        public ArrayList<AuthorsOfBooks> getAuthorsOfBooks() {
            return authorsOfBooks;
        }

        private ArrayList<AuthorsOfBooks> authorsOfBooks;
        AuthorsOfBooks element=null;
        String content="";

        @Override
        public void startDocument() throws SAXException {
            authorsOfBooks = new ArrayList<>();
        }

        @Override
        public void endDocument() throws SAXException {
            super.endDocument();
        }

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            switch (qName){
                case "record":
                    element=new AuthorsOfBooks();
                    break;
            }

        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {

            switch (qName){
                case "authorID":
                    element.authorID=Integer.valueOf(content);
                    break;
                case "bookID":
                    element.bookID=Integer.valueOf(content);
                    break;
                case "record":
                    authorsOfBooks.add(element);
                    element=null;
                    break;
            }
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            content=String.copyValueOf(ch, start, length).trim();
        }


    }

}
