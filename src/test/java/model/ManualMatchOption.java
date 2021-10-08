package model;

public enum ManualMatchOption {

    //Sales Makes
    Chevrolet("Chevrolet"),
    Cadillac("Cadillac"),
    Buick("Buick"),

    //Model
    Avalanche("Avalanche"),
    Beat("Beat"),
    Impala("Impala"),

    //Model Year
    TwentyTwenty("2020"),
    Year2020("2019"),
    Year2019("2019"),
    Year2018("2018"),
    Year2017("2017"),
    Null(""),

    //Badge
    LT("LT"),

    //CC
    CC3Series("3.6"),
    CC2Series("2.0"),

    //Engine
    Engine20Si4("20Si4");

    private String name;

    ManualMatchOption(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
