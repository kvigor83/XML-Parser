package by.kastsiuchenka.third.entity;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;

@XmlType(name = "Type-transport")
@XmlEnum
public enum TypeTransportToy {

    TRUCK,
    CAR,
    TRAILER,
    SPORTCAR,
    BIKE,
    EXCAVATOR;


    public static TypeTransportToy fromValue(String v) {
        return valueOf(v);
    }

}
