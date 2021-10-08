package model;

public enum BulkFluidLocalParts {

    AXLE_FLUID_1("AXLE_FLUID_1"),
    SCREENWASH_1("SCREENWASH_1"),
    SCREENWASH("Screenwash"),
    BRAKE_FLUID_1("BRAKE_FLUID_1"),
    ENGINE_OIL_5("ENGINE_OIL_5"),
    ENGINE_OIL_2("ENGINE_OIL_2"),
    Oil5W30("Oil 5W-30"),
    BrakeDOT3("Brake DOT 3"),
    LR_SCREEN_WASH_500ML("LR SCREEN_WASH 500ML");

    private String part;

    BulkFluidLocalParts(String partName) {
        this.part = partName;
    }

    public String getPart() {
        return part;
    }
}
