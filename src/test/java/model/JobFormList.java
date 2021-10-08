package model;

public enum JobFormList {

    AdHoc("Ad Hoc"),
    CommonJob("Common Job 1"),
    Data("data"),
    Automation_Job("Automation Job"),
    ManufacturerParts("Manufacturer Parts");

    private String name;

    JobFormList(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
