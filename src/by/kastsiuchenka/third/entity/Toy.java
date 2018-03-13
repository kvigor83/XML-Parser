package by.kastsiuchenka.third.entity;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Toy", propOrder = {
        "model",
        "brandName",
        "material",
        "cost",
        "externalParameters"
})
@XmlSeeAlso({
    MusicToy.class,
    TransportToy.class
})
public abstract class Toy {
    @XmlAttribute(name = "toy-id",required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlID
    private String toyId;
    @XmlAttribute(name = "toy-type",required = true)
    private ToyType toyType;
    @XmlElement(required = true)
    private String model;
    @XmlElement(name = "brand-name")
    private String brandName;
    @XmlElement(required = true)
    private Material material;
    @XmlElement(required = true)
    private double cost;
    @XmlElement(name = "external-parameters")
    private ExternalParameter externalParameters = new ExternalParameter();

    public Toy() {
    }

    public Toy(String model, String brandName, Material material, double cost, ExternalParameter externalParameters, String toyId, ToyType toyType) {
        this.model = model;
        this.brandName = brandName;
        this.material = material;
        this.cost = cost;
        this.externalParameters = externalParameters;
        this.toyId = toyId;
        this.toyType = toyType;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String value) {
        this.model = value;
    }

    public String getBrandName() {
        return brandName;
    }
    public void setBrandName(String value) {
        this.brandName = value;
    }

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material value) {
        this.material = value;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double value) {
        this.cost = value;
    }

    public ExternalParameter getExternalParameters() {
        return externalParameters;
    }

    public void setExternalParameters(ExternalParameter value) {
        this.externalParameters = value;
    }

    public String getToyId() {
        return toyId;
    }

    public void setToyId(String value) {
        this.toyId = value;
    }


    public ToyType getToyType() {
        return toyType;
    }

    public void setToyType(ToyType value) {
        this.toyType = value;
    }

    //    @XmlRootElement
    @XmlType(name = "External-parameter", propOrder = {
            "weigth",
            "length",
            "width",
            "heigth"
    })

    public static class ExternalParameter {
        private int weigth;
        private int length;
        private int width;
        private int heigth;

        public ExternalParameter() {
        }

        public ExternalParameter(int weigth, int length, int width, int heigth) {
            this.weigth = weigth;
            this.length = length;
            this.width = width;
            this.heigth = heigth;
        }

        public int getWeigth() {
            return weigth;
        }

        public void setWeigth(int value) {
            this.weigth = value;
        }

        public int getLength() {
            return length;
        }

        public void setLength(int value) {
            this.length = value;
        }

        public int getWidth() {
            return width;
        }

        public void setWidth(int value) {
            this.width = value;
        }

        public int getHeigth() {
            return heigth;
        }

        public void setHeigth(int value) {
            this.heigth = value;
        }

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Toy toy = (Toy) o;

        if (Double.compare(toy.cost, cost) != 0) return false;
        if (toyId != null ? !toyId.equals(toy.toyId) : toy.toyId != null) return false;
        if (toyType != toy.toyType) return false;
        if (model != null ? !model.equals(toy.model) : toy.model != null) return false;
        if (brandName != null ? !brandName.equals(toy.brandName) : toy.brandName != null) return false;
        if (material != toy.material) return false;
        return externalParameters != null ? externalParameters.equals(toy.externalParameters) : toy.externalParameters == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = toyId != null ? toyId.hashCode() : 0;
        result = 31 * result + (toyType != null ? toyType.hashCode() : 0);
        result = 31 * result + (model != null ? model.hashCode() : 0);
        result = 31 * result + (brandName != null ? brandName.hashCode() : 0);
        result = 31 * result + (material != null ? material.hashCode() : 0);
        temp = Double.doubleToLongBits(cost);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (externalParameters != null ? externalParameters.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return  "toyId='" + toyId + '\'' +
                ", toyType=" + toyType +
                ", model='" + model + '\'' +
                ", brandName='" + brandName + '\'' +
                ", material=" + material +
                ", cost=" + cost +
                ", weight=" + externalParameters.weigth;
    }
}
