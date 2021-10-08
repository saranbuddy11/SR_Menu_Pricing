package model;

public enum PartPricePricingTypes {

    CostPricePlus("Cost Price Plus %"),
    CostPriceMinus("Cost Price Minus %"),
    ListPricePlus("List Price Plus %"),
    ListPriceMinus("List Price Minus %"),
    FixedPrice("Fixed Price");

    private String priceType;

    PartPricePricingTypes(String name) {
        this.priceType = name;
    }

    public String getPriceType() {
        return priceType;
    }
}