package HW17_XMLExample;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class XMLValidator {
    public static void main (String[] args){

        SAXParserFactory parserF = SAXParserFactory.newInstance();
        Handler handler = new Handler();
        try {
            SAXParser saxparser = parserF.newSAXParser();
            saxparser.parse(new File("C:\\Users\\Aleksey\\IdeaProjects\\GitHillel2019Maven\\src\\main\\java\\HW17_XMLExample\\myXMLFile.xml"), handler);
        } catch (ParserConfigurationException | SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
