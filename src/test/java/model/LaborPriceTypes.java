package model;

public enum LaborPriceTypes {

    SingleLaborRate("Single Labor Rate"),
    JobDifficulty("Job Difficulty"),
    LaborMatrix("Labor Matrix");

    private String name;

    LaborPriceTypes(String name) {
        this.name = name;
    }

    public String getType() {
        return name;
    }
}