package by.kastsiuchenka.third.dom;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import by.kastsiuchenka.third.entity.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class ToysDOMBuilder {
    private static Logger loggerDOM = LogManager.getRootLogger();
    private Set<Toy> toys;
    private DocumentBuilder docBuilder;

    public ToysDOMBuilder() {
        this.toys = new HashSet<Toy>();
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            docBuilder = factory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            loggerDOM.error("Parser configuration error: " + e);
        }
    }

    public Set<Toy> getToys() {
        return toys;
    }

    public void buildSetToys(String fileName) {
        Document doc;
        try {
            doc = docBuilder.parse(fileName);
            Element root = doc.getDocumentElement();
            NodeList toysList = root.getElementsByTagName("music-toy");
            for (int i = 0; i < toysList.getLength(); i++) {
                Element toyElement = (Element) toysList.item(i);
                Toy toy = buildMusToy(toyElement);
                toys.add(toy);
            }
            toysList = root.getElementsByTagName("transport-toy");
            for (int i = 0; i < toysList.getLength(); i++) {
                Element toyElement = (Element) toysList.item(i);
                Toy toy = buildTransportToy(toyElement);
                toys.add(toy);
            }
        } catch (IOException e) {
            loggerDOM.error("File error or I/O error: " + e);
        } catch (SAXException e) {
            loggerDOM.error("Parsing failure: " + e);
        }
    }

    private Toy buildMusToy(Element toyElement) {
        MusicToy toy = new MusicToy();
        if (!toyElement.getAttribute("toy-id").isEmpty()) {
            toy.setToyId(toyElement.getAttribute("toy-id"));
        }
        if (!toyElement.getAttribute("toy-type").isEmpty()) {
            String tempParameter = toyElement.getAttribute("toy-type").replace("-", "_");
            ToyType toyType = ToyType.valueOf(tempParameter.toUpperCase());
            toy.setToyType(toyType);
        }
        if (toyElement.getAttribute("is-interactive").isEmpty()) {
            toy.setIsInteractive(false);
        } else {
            toy.setIsInteractive(Boolean.parseBoolean(toyElement.getAttribute("is-interactive")));
        }
        toy.setModel(getElementTextContent(toyElement, "model"));
        toy.setBrandName(getElementTextContent(toyElement, "brand-name"));
        Material material = Material.valueOf(getElementTextContent(toyElement, "material").toUpperCase());
        toy.setMaterial(material);
        Double cost = Double.parseDouble(getElementTextContent(toyElement, "cost"));
        toy.setCost(cost);
        Toy.ExternalParameter externalParameter = toy.getExternalParameters();
        Element externalElement = (Element) toyElement.getElementsByTagName("external-parameters").item(0);
        externalParameter.setWeigth(Integer.parseInt(getElementTextContent(externalElement, "weigth")));
        externalParameter.setLength(Integer.parseInt(getElementTextContent(externalElement, "length")));
        externalParameter.setWidth(Integer.parseInt(getElementTextContent(externalElement, "width")));
        externalParameter.setHeigth(Integer.parseInt(getElementTextContent(externalElement, "heigth")));
        String tempParameter = getElementTextContent(toyElement, "type-music-toy").replace("-", "_");
        TypeMusicToy typeMusicToy = TypeMusicToy.valueOf(tempParameter.toUpperCase());
        toy.setTypeMusicToy(typeMusicToy);
        Colour colour = Colour.valueOf(getElementTextContent(toyElement, "main-colour").toUpperCase());
        toy.setMainColour(colour);
        toy.setNumberTones(Integer.parseInt(getElementTextContent(toyElement, "number-tones")));
        return toy;
    }
    private Toy buildTransportToy(Element toyElement) {
        TransportToy toy = new TransportToy();
        if (!toyElement.getAttribute("toy-id").isEmpty()) {
            toy.setToyId(toyElement.getAttribute("toy-id"));
        }
        if (!toyElement.getAttribute("toy-type").isEmpty()) {
            String tempParameter = toyElement.getAttribute("toy-type").replace("-", "_");
            ToyType toyType = ToyType.valueOf(tempParameter.toUpperCase());
            toy.setToyType(toyType);
        }
        if (!toyElement.getAttribute("number-weels").isEmpty()) {
            toy.setNumberWeels(Integer.parseInt(toyElement.getAttribute("number-weels")));
        }
        if (toyElement.getAttribute("scale").isEmpty()) {
            toy.setScale("1:12");
        } else {
            toy.setScale(toyElement.getAttribute("is-interactive"));
        }
        toy.setModel(getElementTextContent(toyElement, "model"));
        toy.setBrandName(getElementTextContent(toyElement, "brand-name"));
        Material material = Material.valueOf(getElementTextContent(toyElement, "material").toUpperCase());
        toy.setMaterial(material);
        Double cost = Double.parseDouble(getElementTextContent(toyElement, "cost"));
        toy.setCost(cost);
        Toy.ExternalParameter externalParameter = toy.getExternalParameters();
        Element externalElement = (Element) toyElement.getElementsByTagName("external-parameters").item(0);
        externalParameter.setWeigth(Integer.parseInt(getElementTextContent(externalElement, "weigth")));
        externalParameter.setLength(Integer.parseInt(getElementTextContent(externalElement, "length")));
        externalParameter.setWidth(Integer.parseInt(getElementTextContent(externalElement, "width")));
        externalParameter.setHeigth(Integer.parseInt(getElementTextContent(externalElement, "heigth")));
        TypeTransportToy typeTransportToy = TypeTransportToy.valueOf(getElementTextContent(toyElement,"type-transport-toy"));
        toy.setTypeTransport(typeTransportToy);
        Colour colour =Colour.valueOf(getElementTextContent(toyElement,"body-colour"));
        toy.setBodyColour(colour);
        TypeControl typeControl=TypeControl.valueOf(getElementTextContent(toyElement,"type-control"));
        toy.setTypeControl(typeControl);
        return toy;
    }
    private static String getElementTextContent(Element element, String elementName) {
        NodeList nList = element.getElementsByTagName(elementName);
        Node node = nList.item(0);
        String text = node.getTextContent();
        return text;
    }

}

