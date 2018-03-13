package by.kastsiuchenka.third.entity;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;

@XmlType(name = "Type-music-toy")
@XmlEnum
public enum TypeMusicToy {

    PIANO,
    PIPE,
    DRUM,
    GUITAR,
    XYLOPHONE,
    TAMBOURINE;


    public static TypeMusicToy fromValue(String v) {
        return valueOf(v);
    }

}
