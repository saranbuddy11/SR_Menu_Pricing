package model;

public enum RuleStructure {

    totalPrice240("240 Set total price excl. tax");

    private String setTotalPrice;

    RuleStructure(String name) {
        this.setTotalPrice = name;
    }

    public String getSetTotalPrice() {
        return setTotalPrice;
    }
}