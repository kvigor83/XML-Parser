package by.kastsiuchenka.third.sax;

public enum ToyEnum {
    TOYS("toys"),
    MUSIC_TOY("music-toy"),
    TRANSPORT_TOY("transport-toy"),
    TOY_ID("toy-id"),
    TOY_TYPE("toy-type"),
    IS_INTERACTIVE("is-interactive"),
    EXTERNAL_PARAMETERS("external-parameters"),
    MODEL("model"),
    BRAND_NAME("brand-name"),
    MATERIAL("material"),
    COST("cost"),
    WEIGTH("weigth"),
    LENGTH("length"),
    WIDTH("width"),
    HEIGTH("heigth"),
    TYPE_MUSIC_TOY("type-music-toy"),
    NUMBER_TONES("number-tones"),
    MAIN_COLOUR("main-colour"),
    TYPE_TRANSPORT_TOY("type-transport-toy"),
    NUMBER_WEELS("number-weels"),
    SCALE("scale"),
    TYPE_CONTROL("type-control"),
    BODY_COLOUR("body-colour");

    private String value;

    private ToyEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
