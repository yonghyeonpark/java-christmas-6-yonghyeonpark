package christmas.model;

import christmas.model.menu.Appetizer;
import christmas.model.menu.Beverage;
import christmas.model.menu.Dessert;
import christmas.model.menu.Main;
import java.util.Map;

public class MenuType {

    private final Map<String, Integer> menuType;

    public MenuType(Map<String, Integer> menuType) {
        this.menuType = menuType;
        setUp();
    }

    private void setUp() {
        menuType.put("애피타이저", 0);
        menuType.put("메인", 0);
        menuType.put("디저트", 0);
        menuType.put("음료", 0);
    }

    public void countMenuType(Map<String, Integer> orders) {
        countAppetizer(orders);
        countMain(orders);
        countDessert(orders);
        countBeverage(orders);
    }

    private void countAppetizer(Map<String, Integer> orders) {
        for (Appetizer appetizer : Appetizer.values()) {
            if (orders.containsKey(appetizer.getName())) {
                menuType.put("애피타이저", menuType.get("애피타이저") + orders.get(appetizer.getName()));
            }
        }
    }

    private void countMain(Map<String, Integer> orders) {
        for (Main main : Main.values()) {
            if (orders.containsKey(main.getName())) {
                menuType.put("메인", menuType.get("메인") + orders.get(main.getName()));
            }
        }
    }

    private void countDessert(Map<String, Integer> orders) {
        for (Dessert dessert : Dessert.values()) {
            if (orders.containsKey(dessert.getName())) {
                menuType.put("디저트", menuType.get("디저트") + orders.get(dessert.getName()));
            }
        }
    }

    private void countBeverage(Map<String, Integer> orders) {
        for (Beverage beverage : Beverage.values()) {
            if (orders.containsKey(beverage.getName())) {
                menuType.put("음료", menuType.get("음료") + orders.get(beverage.getName()));
            }
        }
    }

    public boolean isOrderOnlyBeverage() {
        return (menuType.get("애피타이저") == 0) && (menuType.get("메인") == 0) && (menuType.get("디저트") == 0);
    }
}
