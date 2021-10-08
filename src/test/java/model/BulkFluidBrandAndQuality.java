package model;

public enum BulkFluidBrandAndQuality {

    SNPlus("SNPlus"),
    EmptyValue(""),
    Dexos1("Dexos1");

    private String brand;

    BulkFluidBrandAndQuality(String partName) {
        this.brand = partName;
    }

    public String getBrand() {
        return brand;
    }
}
