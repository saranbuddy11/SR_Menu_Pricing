package model;

public enum BasedOnPartPriceType {

    RetailMinus("Retail Minus"),
    None("None"),
    CostPlus("Cost Plus");

    private String name;

    BasedOnPartPriceType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
