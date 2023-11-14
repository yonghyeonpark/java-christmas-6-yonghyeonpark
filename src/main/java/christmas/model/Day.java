package christmas.model;

public enum Day {

    WEEKDAY("weekday"),
    WEEKEND("weekend"),
    SPECIAL_DAY("specialDay"),
    ORDINARY_DAY("ordinaryDay");

    private String name;

    Day(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
