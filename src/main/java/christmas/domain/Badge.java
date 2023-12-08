package christmas.domain;

public enum Badge {

    STAR("별", 5_000),
    TREE("트리", 10_000),
    SANTA("산타", 20_000);

    private String name;
    private int standard;

    Badge(String name, int standard) {
        this.name = name;
        this.standard = standard;
    }

    public String getName() {
        return name;
    }

    public int getStandard() {
        return standard;
    }
}
