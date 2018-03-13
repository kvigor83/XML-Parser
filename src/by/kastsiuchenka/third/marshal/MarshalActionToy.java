package by.kastsiuchenka.third.marshal;

import by.kastsiuchenka.third.entity.Toys;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.SAXException;
import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class MarshalActionToy {
    private static Logger actionLogger = LogManager.getRootLogger();

    public void saveWithMarshaller(Toys toys, String fileName) {

        try {
            JAXBContext context = JAXBContext.newInstance(Toys.class);
            Marshaller m = context.createMarshaller();

            m.marshal(toys, new FileOutputStream(fileName));
            actionLogger.info("XML file has been created");
        } catch (FileNotFoundException e) {
            actionLogger.error("XML file can't be created" + e);
        } catch (JAXBException e) {
            actionLogger.error("JAXB-context wrong " + e);
        }

    }

    public Toys useUnMarshalWithXSD(String fileName, String schemaName) {
        Toys toys=null;
        JAXBContext context;
        try {
            context = JAXBContext.newInstance(Toys.class);
            Unmarshaller um = context.createUnmarshaller();
            SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            File schemaLocation = new File(schemaName);
            Schema schema = factory.newSchema(schemaLocation);
            um.setSchema(schema);
            toys = (Toys) um.unmarshal(new File(fileName));
        } catch (JAXBException e) {
            actionLogger.error("JAXB-context wrong ", e);
        } catch (SAXException e) {
            actionLogger.error("schema  wrong ", e);
        }
        return toys;

    }

}
