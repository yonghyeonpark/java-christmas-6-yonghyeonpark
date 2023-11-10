package christmas.model.menutype;

public enum Main {

    T_BON_STAKE("티본스테이크", 55_000),
    BBQ_RIB("바비큐립", 54_000),
    SEAFOOD_PASTA("해산물파스타", 35_000),
    CHRISTMAS_PASTA("크리스마스파스타", 25_000);

    private String name;
    private int price;

    Main(String name, int price) {
        this.name = name;
        this.price = price;
    }
}
