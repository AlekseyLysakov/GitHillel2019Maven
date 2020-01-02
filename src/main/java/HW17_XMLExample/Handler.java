package HW17_XMLExample;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class Handler extends DefaultHandler {

    @Override
    public void startDocument() throws SAXException{
        System.out.println("Parsing started..");
    }

    @Override
    public void endDocument() throws SAXException{
        System.out.println("Parsing finished..");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {

    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {

    }

    @Override
    public void characters(char[] ch, int start, int end) throws SAXException {
        String str = new String(ch, start, end);
        System.out.println(str);
        }
    }

