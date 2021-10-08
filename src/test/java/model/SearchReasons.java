package model;

public enum SearchReasons {

    All("All"),
    Pricing("Pricing"),
    PartsAvailability("Parts Availability"),
    ServiceAvailability("Service Availability");

    private String reason;

    SearchReasons(String reason) {
        this.reason = reason;
    }

    public String getReason() {
        return reason;
    }
}