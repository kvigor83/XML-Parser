package by.kastsiuchenka.third.sax;

import by.kastsiuchenka.third.entity.Material;
import by.kastsiuchenka.third.entity.MusicToy;
import by.kastsiuchenka.third.entity.Toy;
import by.kastsiuchenka.third.entity.ToyType;
import by.kastsiuchenka.third.entity.TransportToy;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.Set;

public class ToyHandler extends DefaultHandler {
    private Set<Toy> toys;
    private Toy current = null;
    private ToyEnum currentEnum = null;
    private EnumSet<ToyEnum> withText;

    public ToyHandler() {
        toys = new HashSet<>();
        withText = EnumSet.range(ToyEnum.MODEL, ToyEnum.BODY_COLOUR);
    }

    public Set<Toy> getToys() {
        return toys;
    }

    @Override
    public void startDocument() {

        System.out.println("Parsing started");
    }

    public void startElement(String uri, String localName, String qName, Attributes attrs) {

        if ("music-toy".equals(localName)) {
            MusicToy musicToy = new MusicToy();
            for (int i = 0; i < attrs.getLength(); i++) {
                if ("toy-id".equals(attrs.getLocalName(i))) {
                    musicToy.setToyId(attrs.getValue(i));
                }
                if ("toy-type".equals(attrs.getLocalName(i))) {
                    String tempParameter = attrs.getValue(i).replace("-", "_");
                    ToyType toyType = ToyType.valueOf(tempParameter.toUpperCase());
                    musicToy.setToyType(toyType);
                }
                if ("is-interactive".equals(attrs.getLocalName(i)) && attrs.getLength() == 3) {
                    musicToy.setIsInteractive(Boolean.parseBoolean(attrs.getValue(i)));
                }
                if ("is-interactive".equals(attrs.getLocalName(i)) && attrs.getLength() != 3) {
                    musicToy.setIsInteractive(false);
                }
            }
            current = musicToy;

        } else if ("transport-toy".equals(localName)) {
            TransportToy transportToy = new TransportToy();
            for (int i = 0; i < attrs.getLength(); i++) {
                if ("toy-id".equalsIgnoreCase(attrs.getLocalName(i))) {
                    transportToy.setToyId(attrs.getValue(i));
                }
                if ("toy-type".equalsIgnoreCase(attrs.getLocalName(i))) {
                    String tempParameter = attrs.getValue(i).replace("-", "_");
                    ToyType toyType = ToyType.valueOf(tempParameter.toUpperCase());
                    transportToy.setToyType(toyType);
                }
                if ("number-weels".equalsIgnoreCase(attrs.getLocalName(i))) {
                    transportToy.setNumberWeels(Integer.parseInt(attrs.getValue(i)));
                }
                if ("scale".equalsIgnoreCase(attrs.getLocalName(i)) && attrs.getLength() == 4) {
                    transportToy.setScale(attrs.getValue(i));
                }
                if ("scale".equalsIgnoreCase(attrs.getLocalName(i)) && attrs.getLength() != 4) {
                    transportToy.setScale("1:12");
                }
            }
            current = transportToy;
        } else {
            ToyEnum temp = ToyEnum.valueOf(localName.toUpperCase().replace("-", "_"));
            if (withText.contains(temp)) {
                currentEnum = temp;
            }
        }
    }

    public void endElement(String uri, String localName, String qName) {
        if ("music-toy".equals(localName) || "transport-toy".equals(localName)) {
            toys.add(current);
        }
    }

    @Override
    public void endDocument() {
        System.out.println("\nParsing finished");
    }

    public void characters(char[] ch, int start, int length) {
        String s = new String(ch, start, length).trim();
        s.replace("-", "_");
        if (currentEnum != null) {
            switch (currentEnum) {
                case MODEL:
                    current.setModel(s);
                    break;
                case BRAND_NAME:
                    current.setBrandName(s);
                    break;
                case MATERIAL:
                    Material material = Material.valueOf(s.toUpperCase());
                    current.setMaterial(material);
                    break;
                case COST:
                    current.setCost(Double.parseDouble(s));
                    break;
                case WEIGTH:
                    current.getExternalParameters().setWeigth(Integer.parseInt(s));
                    break;
                case LENGTH:
                    current.getExternalParameters().setLength(Integer.parseInt(s));
                    break;
                case WIDTH:
                    current.getExternalParameters().setWidth(Integer.parseInt(s));
                    break;
                case HEIGTH:
                    current.getExternalParameters().setHeigth(Integer.parseInt(s));
                    break;
                case TYPE_MUSIC_TOY:
                    current.setBrandName(s);
                    break;
                case NUMBER_TONES:
                    current.getExternalParameters().setWidth(Integer.parseInt(s));
                    break;
                case MAIN_COLOUR:
                    current.setBrandName(s);
                    break;
                case TYPE_TRANSPORT_TOY:
                    current.setModel(s);
                    break;
                case TYPE_CONTROL:
                    current.setBrandName(s);
                    break;
                case BODY_COLOUR:
                    current.setModel(s);
                    break;
            }
        }
        currentEnum = null;
    }
}
