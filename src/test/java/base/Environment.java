package base;

public enum Environment {

    PROD("prod"),
    UAT("uat"),
    QC("qc"),
    UNKNOWN("unknown");

    private String name;

    Environment(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
