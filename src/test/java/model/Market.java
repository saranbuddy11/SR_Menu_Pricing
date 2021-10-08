package model;

public enum Market {

    ALGERIA("Algeria"),
    AUSTRIA("Austria"),
    BELGIUM("Belgium"),
    BOSNIA_HERZEGOVINA("Bosnia & Herzegovina"),
    BRAZIL("Brazil"),
    BULGARIA("Bulgaria"),
    CROATIA("Croatia"),
    CYPRUS("Cyprus"),
    CZECH_REPUBLIC("Czech Republic"),
    DENMARK("Denmark"),
    EGYPT("Egypt"),
    ESTONIA("Estonia"),
    FINLAND("Finland"),
    FRANCE("France"),
    GERMANY("Germany"),
    GREECE("Greece"),
    GREAT_BRITAIN("Great Britain"),
    HUNGARY("Hungary"),
    ICELAND("Iceland"),
    IRELAND("Ireland"),
    ISRAEL("Israel"),
    ITALY("Italy"),
    JORDAN("Jordan"),
    LATVIA("Latvia"),
    LEBANON("Lebanon"),
    LITHUANIA("Lithuania"),
    LUXEMBOURG("Luxembourg"),
    MACEDONIA("Macedonia"),
    MALTA("Malta"),
    MONTENEGRO("Montenegro"),
    MOROCCO("Morocco"),
    NETHERLANDS("Netherlands"),
    NORWAY("Norway"),
    POLAND("Poland"),
    PORTUGAL("Portugal"),
    ROMANIA("Romania"),
    RUSSIA("Russia"),
    SERBIA("Serbia"),
    SINGAPORE("Singapore"),
    SLOVAKIA("Slovakia"),
    SLOVENIA("Slovenia"),
    ES("ES"),
    SWEDEN("Sweden"),
    SWITZERLAND("Switzerland"),
    TUNISIA("Tunisia"),
    TURKEY("Turkey"),
    UNITED_ARAB_EMIRATES("United Arab Emirates"),
    UNITED_KINGDOM("United Kingdom"),
    UNITED_STATES("United States"),
    GB("GB"),
    PL("PL");

    private String name;

    Market(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
