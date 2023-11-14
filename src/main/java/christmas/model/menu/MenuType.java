package christmas.model.menu;

public enum MenuType {

    Appetizer("애피타이저"),
    Main("메인"),
    Dessert("디저트"),
    Beverage("음료");

    private String name;

    MenuType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
