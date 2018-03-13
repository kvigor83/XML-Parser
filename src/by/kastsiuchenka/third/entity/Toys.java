package by.kastsiuchenka.third.entity;

import java.util.ArrayList;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.*;


//@XmlAccessorType(XmlAccessType.FIELD)
//@XmlType(name = "", propOrder = {
//        "toy"
//})

@XmlRootElement
public class Toys {

    @XmlElement(name = "toy")
    private ArrayList<Toy> toy = new ArrayList<>();

    public Toys() {
        super();
    }

    public void setToyList(ArrayList<Toy> toy) {
        this.toy = toy;
    }

    public boolean addToy(Toy toy1) {
        return toy.add(toy1);
    }



    public int getSize(){
        int number=toy.size();
        return number;
    }

    @Override
    public String toString() {

        return "Toys{" +
                "toy=" + toy +
                '}';
    }
}
