package librarian.Parsers;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import librarian.Author;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * Created by dreaminteam on 18.12.14.
 */
public class DomAuthorParser {

    public static void main(String[] args) throws Exception {

        DomAuthorParser domAuthorParser = new DomAuthorParser();
        ArrayList<Author> authors = (ArrayList) domAuthorParser.authorsPars(
                "/home/dreaminteam/IdeaProjects/HelloIdea/src/librarian/xml/author.xml");

        //Printing the Employee list populated.
        for (Author author : authors) {
            System.out.println(author.toString());
        }
    }

    public List authorsPars(String path) throws Exception {
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

        List<Author> authorList = new ArrayList<>();

        //Iterating through the nodes and extracting the data.
        NodeList nodeList = document.getDocumentElement().getChildNodes();

        for (int i = 0; i < nodeList.getLength(); i++) {

            //We have encountered an <employee> tag.
            Node node = nodeList.item(i);
            if (node instanceof Element) {
                Author author = new Author();
                author.id = node.getAttributes().
                        getNamedItem("id").getNodeValue();

                NodeList childNodes = node.getChildNodes();
                for (int j = 0; j < childNodes.getLength(); j++) {
                    Node cNode = childNodes.item(j);

                    //Identifying the child tag of employee encountered.
                    if (cNode instanceof Element) {
                        String content = cNode.getLastChild().
                                getTextContent().trim();
                        switch (cNode.getNodeName()) {
                            case "ownName":
                                author.ownName = content;
                                break;
                            case "surName":
                                author.surName = content;
                                break;
                            case "dateOfBirth":
                                author.dateOfBirth = content;
                                break;
                        }
                    }
                }
                authorList.add(author);
            }
        }
        return authorList;

    }


}
