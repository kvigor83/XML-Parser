
package by.kastsiuchenka.third.entity;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;

@XmlType(name = "Material")
@XmlEnum
public enum Material {

    PLASTIC, WOOD, STEEL, GLASS, TEXTALE, PAPER;


}
