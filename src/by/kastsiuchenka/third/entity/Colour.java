
package by.kastsiuchenka.third.entity;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;

@XmlType(name = "Colour")
@XmlEnum
public enum Colour {

    BLUE,
    RED,
    WHITE,
    BLACK,
    YELLOW,
    ORANGE,
    GREEN,
    BROWN;


    public static Colour fromValue(String v) {
        return valueOf(v);
    }

}
