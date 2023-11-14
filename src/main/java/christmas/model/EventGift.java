package christmas.model;

public enum EventGift {

    STAR_BADGE("별"),
    TREE_BADGE("트리"),
    SANTA_BADGE("산타"),
    ONE_CHAMPAGNE("샴페인 1개");

    private String name;

    EventGift(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
