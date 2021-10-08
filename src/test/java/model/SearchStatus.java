package model;

public enum SearchStatus {

    All("All"),
    Saved("Saved"),
    Deleted("Deleted"),
    Lost("Lost"),
    Deferred("Deferred");


    private String name;

    SearchStatus(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}