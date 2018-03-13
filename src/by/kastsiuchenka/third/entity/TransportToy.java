package by.kastsiuchenka.third.entity;

import javax.xml.bind.annotation.*;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Transport-toy", propOrder = {
        "typeTransport",
        "typeControl",
        "bodyColour"
})
public class TransportToy extends Toy {

    @XmlElement(name = "type-transport")
    private TypeTransportToy typeTransport;
    @XmlElement(name = "type-control")
    private TypeControl typeControl;
    @XmlElement(name = "body-colour")
    private Colour bodyColour;
    @XmlAttribute(name = "number-weels",required = false)
    private Integer numberWeels;
    @XmlAttribute(name = "scale",required = false)
    private String scale;

    public TransportToy() {
    }

    public TransportToy(String model, String brandName, Material material, double cost,
                        ExternalParameter externalParameters, String toyId, ToyType toyType,
                        TypeTransportToy typeTransport, TypeControl typeControl, Colour bodyColour,
                        Integer numberWeels, String scale) {
        super(model, brandName, material, cost, externalParameters, toyId, toyType);
        this.typeTransport = typeTransport;
        this.typeControl = typeControl;
        this.bodyColour = bodyColour;
        this.numberWeels = numberWeels;
        this.scale = scale;
    }

    public TypeTransportToy getTypeTransport() {
        return typeTransport;
    }

    public void setTypeTransport(TypeTransportToy value) {
        this.typeTransport = value;
    }

    public TypeControl getTypeControl() {
        return typeControl;
    }

    public void setTypeControl(TypeControl value) {
        this.typeControl = value;
    }

    public Colour getBodyColour() {
        return bodyColour;
    }

    public void setBodyColour(Colour value) {
        this.bodyColour = value;
    }

    public int getNumberWeels() {
        if (numberWeels == null) {
            return 4;
        } else {
            return numberWeels;
        }
    }

    public void setNumberWeels(Integer value) {
        this.numberWeels = value;
    }

    public String getScale() {
        return scale;
    }

    public void setScale(String value) {
        this.scale = value;
    }

    @Override
    public String toString() {
        return "\nTransportToy{" + super.toString()+
                ", typeTransport=" + typeTransport +
                ", typeControl=" + typeControl +
                ", bodyColour=" + bodyColour +
                ", numberWeels=" + numberWeels +
                ", scale='" + scale + '\'' +
                '}';
    }
}
