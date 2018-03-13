package by.kastsiuchenka.third.stax;

import by.kastsiuchenka.third.entity.*;
import by.kastsiuchenka.third.exception.ValidatorException;
import by.kastsiuchenka.third.sax.ToyEnum;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

public class ToyStAXBuilder {
    private static Logger loggerStAX = LogManager.getRootLogger();
    private HashSet<Toy> toys = new HashSet<>();
    private XMLInputFactory inputFactory;

    public ToyStAXBuilder() {
        inputFactory = XMLInputFactory.newInstance();
    }

    public Set<Toy> getToys() {
        return toys;
    }

    public void buildSetToys(String fileName) {
        FileInputStream inputStream = null;
        XMLStreamReader reader = null;
        String tempName;
        try {
            inputStream = new FileInputStream(new File(fileName));
            reader = inputFactory.createXMLStreamReader(inputStream);
            while (reader.hasNext()) {
                int type = reader.next();
                if (type == XMLStreamConstants.START_ELEMENT) {
                    tempName = reader.getLocalName().replace("-", "_");
                    if (ToyEnum.valueOf(tempName.toUpperCase()) == ToyEnum.MUSIC_TOY ) {
                        Toy toy = null;
                        try {
                            toy = buildMusicToy(reader);
                        } catch (ValidatorException e) {
                            loggerStAX.error("error of creation MusicToy", e);
                        }
                        toys.add(toy);
                    }
                    if (ToyEnum.valueOf(tempName.toUpperCase()) == ToyEnum.TRANSPORT_TOY) {
                        Toy toy = null;
                        try {
                            toy = buildTransportToy(reader);
                        } catch (ValidatorException e) {
                            loggerStAX.error("error of creation TransportToy", e);
                        }
                        toys.add(toy);
                    }
                }
            }
        } catch (XMLStreamException ex) {
            loggerStAX.error("StAX parsing error! " + ex.getMessage());
        } catch (FileNotFoundException ex) {
            loggerStAX.error("File " + fileName + " not found! " + ex.getMessage());
        } finally {
            try {
                if (inputStream != null) {
                    inputStream.close();
                }
            } catch (IOException ex) {
                loggerStAX.error("Impossible close file " + fileName + " : " + ex.getMessage());
            }
        }
    }

    private Toy buildMusicToy(XMLStreamReader reader) throws ValidatorException {

        MusicToy toy = new MusicToy();
        toy.setToyId(reader.getAttributeValue(null, ToyEnum.TOY_ID.getValue()));
        ToyType toyType = ToyType.valueOf(reader.getAttributeValue(null, ToyEnum.TOY_TYPE.getValue()).toUpperCase());
        toy.setToyType(toyType);
        if (reader.getAttributeCount() == 3) {
            Boolean bollInteractive = Boolean.parseBoolean(reader.getAttributeValue(null, ToyEnum.TOY_TYPE.getValue()));
            toy.setIsInteractive(bollInteractive);
        } else {
            toy.setIsInteractive(false);
        }

        String tempName;
        try {
            while (reader.hasNext()) {
                int type = reader.next();
                switch (type) {
                    case XMLStreamConstants.START_ELEMENT:
                        tempName = reader.getLocalName().replace("-", "_");
                        switch (ToyEnum.valueOf(tempName.toUpperCase())) {
                            case MODEL:
                                toy.setModel(getXMLText(reader));
                                break;
                            case BRAND_NAME:
                                toy.setBrandName(getXMLText(reader));
                                break;
                            case MATERIAL:
                                Material material = Material.valueOf(getXMLText(reader).toUpperCase());
                                toy.setMaterial(material);
                                break;
                            case COST:
                                tempName = getXMLText(reader);
                                toy.setCost(Double.parseDouble(tempName));
                                break;
                            case EXTERNAL_PARAMETERS:
                                toy.setExternalParameters(getXMLExternal(reader));
                                break;
                            case TYPE_MUSIC_TOY:
                                TypeMusicToy typeMusicToy = TypeMusicToy.valueOf(getXMLText(reader).toUpperCase());
                                toy.setTypeMusicToy(typeMusicToy);
                                break;
                            case NUMBER_TONES:
                                tempName = getXMLText(reader);
                                toy.setNumberTones(Integer.parseInt(tempName));
                                break;
                            case MAIN_COLOUR:
                                Colour colour = Colour.valueOf(getXMLText(reader).toUpperCase());
                                toy.setMainColour(colour);
                                break;
                        }
                        break;
                    case XMLStreamConstants.END_ELEMENT:
                        tempName = reader.getLocalName();
                        if (ToyEnum.valueOf(tempName.toUpperCase().replace("-", "_")) == ToyEnum.MUSIC_TOY) {
                            return toy;
                        }
                        break;
                }
            }
        } catch (XMLStreamException e) {
            loggerStAX.error("No element or wrong element", e);
        }
        throw new ValidatorException("Unknown element in tag music-toy");
    }

    private Toy buildTransportToy(XMLStreamReader reader) throws ValidatorException {

        TransportToy toy = new TransportToy();
        toy.setToyId(reader.getAttributeValue(null, ToyEnum.TOY_ID.getValue()));
        ToyType toyType = ToyType.valueOf(reader.getAttributeValue(null, ToyEnum.TOY_TYPE.getValue()).toUpperCase());
        toy.setToyType(toyType);
        int nunberWeels = Integer.parseInt(reader.getAttributeValue(null, ToyEnum.NUMBER_WEELS.getValue()));
        toy.setNumberWeels(nunberWeels);
        if (reader.getAttributeCount() == 4) {
            toy.setScale(reader.getAttributeValue(null, ToyEnum.SCALE.getValue()));
        } else {
            toy.setScale("1:12");
        }
        String tempName;
        try {
            while (reader.hasNext()) {
                int type = reader.next();
                switch (type) {
                    case XMLStreamConstants.START_ELEMENT:
                        tempName = reader.getLocalName().replace("-", "_");
                        switch (ToyEnum.valueOf(tempName.toUpperCase())) {
                            case MODEL:
                                toy.setModel(getXMLText(reader));
                                break;
                            case BRAND_NAME:
                                toy.setBrandName(getXMLText(reader));
                                break;
                            case MATERIAL:
                                Material material = Material.valueOf(getXMLText(reader).toUpperCase());
                                toy.setMaterial(material);
                                break;
                            case COST:
                                tempName = getXMLText(reader);
                                toy.setCost(Double.parseDouble(tempName));
                                break;
                            case EXTERNAL_PARAMETERS:
                                toy.setExternalParameters(getXMLExternal(reader));
                                break;
                            case TYPE_TRANSPORT_TOY:
                                TypeTransportToy typeTransportToy = TypeTransportToy.valueOf(getXMLText(reader).toUpperCase());
                                toy.setTypeTransport(typeTransportToy);
                                break;
                            case TYPE_CONTROL:
                                TypeControl typeControl = TypeControl.valueOf(getXMLText(reader).toUpperCase());
                                toy.setTypeControl(typeControl);
                                break;
                            case BODY_COLOUR:
                                Colour colour = Colour.valueOf(getXMLText(reader).toUpperCase());
                                toy.setBodyColour(colour);
                                break;
                        }
                        break;
                    case XMLStreamConstants.END_ELEMENT:
                        tempName = reader.getLocalName();
                        if (ToyEnum.valueOf(tempName.toUpperCase().replace("-", "_")) == ToyEnum.MUSIC_TOY) {
                            return toy;
                        }
                        break;
                }
            }
        } catch (XMLStreamException e) {
            loggerStAX.error("No element or wrong element", e);
        }
        throw new ValidatorException("Unknown element in tag music-toy");
    }

    private Toy.ExternalParameter getXMLExternal(XMLStreamReader reader) throws ValidatorException {
        Toy.ExternalParameter externalParam = new Toy.ExternalParameter();
        int type;
        String tempName;
        try {
            while (reader.hasNext()) {
                type = reader.next();
                switch (type) {
                    case XMLStreamConstants.START_ELEMENT:
                        tempName = reader.getLocalName();
                        switch (ToyEnum.valueOf(tempName.toUpperCase())) {
                            case WEIGTH:
                                externalParam.setWeigth(Integer.parseInt(getXMLText(reader)));
                                break;
                            case LENGTH:
                                externalParam.setLength(Integer.parseInt(getXMLText(reader)));
                                break;
                            case WIDTH:
                                externalParam.setWidth(Integer.parseInt(getXMLText(reader)));
                                break;
                            case HEIGTH:
                                externalParam.setHeigth(Integer.parseInt(getXMLText(reader)));
                                break;
                        }
                        break;
                    case XMLStreamConstants.END_ELEMENT:
                        tempName = reader.getLocalName();
                        if (ToyEnum.valueOf(tempName.toUpperCase().replace("-", "_")) == ToyEnum.EXTERNAL_PARAMETERS) {
                            return externalParam;
                        }
                        break;
                }
            }
        } catch (XMLStreamException e) {
            loggerStAX.error("No element or wrong element in external-parameter", e);
        }
        throw new ValidatorException("Unknown element in tag external-parameter");
    }

    private String getXMLText(XMLStreamReader reader) {
        String text = null;
        try {
            text = null;
            if (reader.hasNext()) {
                reader.next();
                text = reader.getText();
            }
        } catch (XMLStreamException e) {
            loggerStAX.error("reading error from tag", e);
        }
        return text;
    }
}
