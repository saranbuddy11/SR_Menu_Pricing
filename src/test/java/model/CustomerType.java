package model;

public enum CustomerType {

    Retail("Retail"),
    Loyalty("Loyalty"),
    New("New"),
    Test("test"),
    Veteran("Veteran");

    private String name;

    CustomerType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
