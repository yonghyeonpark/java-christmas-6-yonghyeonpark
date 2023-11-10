package christmas.model.menutype;

public enum Dessert {

    CHOCO_CAKE("초코케이크", 15_000),
    ICE_CREAM("아이스크림", 5_000);

    private String name;
    private int price;

    Dessert(String name, int price) {
        this.name = name;
        this.price = price;
    }
}
