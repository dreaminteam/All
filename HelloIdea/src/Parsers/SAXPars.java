package Parsers;

/**
 * Created by dreaminteam on 8.12.14.
 */

import org.xml.sax.AttributeList;
import org.xml.sax.helpers.*;
import org.xml.sax.*;
import javax.management.*;
import javax.xml.parsers.*;

public class SAXPars extends DefaultHandler {

    String thisElement = "";
    Doctor doc = new Doctor();

    @Override
    public void setDocumentLocator(Locator locator) {

    }

    @Override
    public void startDocument() throws SAXException {
        System.out.println("Start parser XML...");

    }

    @Override
    public void endDocument() throws SAXException {
        System.out.print(doc.toString());
        System.out.println();
        System.out.println("Stop parser XML");
    }

    @Override
    public void startPrefixMapping(String prefix, String uri) throws SAXException {

    }

    @Override
    public void endPrefixMapping(String prefix) throws SAXException {

    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attrs) throws SAXException {

        thisElement = qName;

    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        thisElement = "";
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {

        if (thisElement.equals("id")) {
            doc.setId(new Integer(new String(ch, start, length)));
        }
        if (thisElement.equals("fam")) {
            doc.setFam(new String(ch, start, length));
        }
        if (thisElement.equals("name")) {
            doc.setName(new String(ch, start, length));
        }
        if (thisElement.equals("otc")) {
            doc.setOtc(new String(ch, start, length));
        }
        ;
        if (thisElement.equals("date")) {
            doc.setDate(new String(ch, start, length));
        }
        if (thisElement.equals("vdolid")) {
            doc.setVdolid(new Integer(new String(ch, start, length)));
        }
        if (thisElement.equals("specid")) {
            doc.setSpecid(new Integer(new String(ch, start, length)));
        }
        if (thisElement.equals("stav")) {
            doc.setStav(new Double(new String(new String(ch, start, length))));
        }
    }

    @Override
    public void ignorableWhitespace(char[] ch, int start, int length) throws SAXException {

    }

    @Override
    public void processingInstruction(String target, String data) throws SAXException {

    }

    @Override
    public void skippedEntity(String name) throws SAXException {

    }
}





