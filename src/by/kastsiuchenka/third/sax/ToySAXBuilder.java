package by.kastsiuchenka.third.sax;

import java.io.IOException;
import java.util.Set;
import by.kastsiuchenka.third.entity.Toy;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

public class ToySAXBuilder {
    private static Logger logger = LogManager.getRootLogger();
    private Set<Toy> toys;
    private ToyHandler th;
    private XMLReader reader;

    public ToySAXBuilder() {
        th = new ToyHandler();
        try {
            reader = XMLReaderFactory.createXMLReader();
            reader.setContentHandler(th);
        } catch (
                SAXException e)
        {
            logger.error("SAX-parsing error " , e);
        }

    }

    public Set<Toy> getToys() {
        return toys;
    }

    public void buildSetToys(String fileName) {
        try {
            reader.parse(fileName);
        } catch (SAXException e) {
            logger.error("SAX-parsing error " + e.getMessage());
        } catch (IOException e) {
            logger.error("wrong XML file name " + e.getMessage());
        }
        toys = th.getToys();
    }
    @Override
    public String toString() {
        String s="toy[ ";
        for(Toy toy:toys){
            s+=(toy.toString())+" ";
        }
        return s+" ]";
    }
}
