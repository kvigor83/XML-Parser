package by.kastsiuchenka.third.entity;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;

@XmlType(name = "Toy-type")
@XmlEnum
public enum ToyType {

    TRANSPORT_TOY,
    SPORT_TOY,
    DOLL,
    MUSIC_TOY;


    public static ToyType fromValue(String v) {
        return valueOf(v);
    }

}
