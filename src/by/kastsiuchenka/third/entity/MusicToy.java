package by.kastsiuchenka.third.entity;

import javax.xml.bind.annotation.*;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Music-toy", propOrder = {
        "typeMusicToy",
        "numberTones",
        "mainColour"
})
public class MusicToy extends Toy {
    @XmlElement(name = "type-music-toy")
    private TypeMusicToy typeMusicToy;
    @XmlElement(name = "number-tones")
    private int numberTones;
    @XmlElement(name = "main-colour")
    private Colour mainColour;
    @XmlAttribute(name = "is-interactive", required = false)
    private Boolean isInteractive;

    public MusicToy(){
    }

    public MusicToy(String model, String brandName, Material material, double cost,
                    ExternalParameter externalParameters, String toyId, ToyType toyType, TypeMusicToy typeMusicToy,
                    int numberTones, Colour mainColour, Boolean isInteractive) {
        super(model, brandName, material, cost, externalParameters, toyId, toyType);
        this.typeMusicToy = typeMusicToy;
        this.numberTones = numberTones;
        this.mainColour = mainColour;
        this.isInteractive = isInteractive;
    }

    public TypeMusicToy getTypeMusicToy() {
        return typeMusicToy;
    }

    public void setTypeMusicToy(TypeMusicToy value) {
        this.typeMusicToy = value;
    }

    public int getNumberTones() {
        return numberTones;
    }

    public void setNumberTones(int value) {
        this.numberTones = value;
    }

    public Colour getMainColour() {
        return mainColour;
    }

    public void setMainColour(Colour value) {
        this.mainColour = value;
    }

    public boolean isInteractive() {
        if (isInteractive == null) {
            return false;
        } else {
            return isInteractive;
        }
    }

    public void setIsInteractive(Boolean value) {
        this.isInteractive = value;
    }

    @Override
    public String toString() {
        return "\nMusicToy{" + super.toString()+
                ", typeMusicToy=" + typeMusicToy +
                ", numberTones=" + numberTones +
                ", mainColour=" + mainColour +
                ", isInteractive=" + isInteractive +
                '}';
    }
}
