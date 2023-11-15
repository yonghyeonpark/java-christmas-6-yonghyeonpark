package christmas.model;

import christmas.model.menu.Appetizer;
import christmas.model.menu.Beverage;
import christmas.model.menu.Dessert;
import christmas.model.menu.Main;
import java.util.Map;

public class Menu {

    private static final int INITIAL_VALUE = 0;
    private static final String APPETIZER = christmas.model.menu.MenuType.Appetizer.getName();
    private static final String MAIN = christmas.model.menu.MenuType.Main.getName();
    private static final String DESSERT = christmas.model.menu.MenuType.Dessert.getName();
    private static final String BEVERAGE = christmas.model.menu.MenuType.Beverage.getName();

    private final Map<String, Integer> menuType;

    public Menu(Map<String, Integer> menuType) {
        this.menuType = menuType;
    }

    public Map<String, Integer> getMenuType() {
        return menuType;
    }

    public void countMenuType(Map<String, Integer> orders) {
        setUp();
        countAppetizer(orders);
        countMain(orders);
        countDessert(orders);
        countBeverage(orders);
    }

    private void setUp() {
        menuType.put(APPETIZER, INITIAL_VALUE);
        menuType.put(MAIN, INITIAL_VALUE);
        menuType.put(DESSERT, INITIAL_VALUE);
        menuType.put(BEVERAGE, INITIAL_VALUE);
    }

    private void countAppetizer(Map<String, Integer> orders) {
        for (Appetizer appetizer : Appetizer.values()) {
            if (orders.containsKey(appetizer.getName())) {
                menuType.put(APPETIZER, menuType.get(APPETIZER) + orders.get(appetizer.getName()));
            }
        }
    }

    private void countMain(Map<String, Integer> orders) {
        for (Main main : Main.values()) {
            if (orders.containsKey(main.getName())) {
                menuType.put(MAIN, menuType.get(MAIN) + orders.get(main.getName()));
            }
        }
    }

    private void countDessert(Map<String, Integer> orders) {
        for (Dessert dessert : Dessert.values()) {
            if (orders.containsKey(dessert.getName())) {
                menuType.put(DESSERT, menuType.get(DESSERT) + orders.get(dessert.getName()));
            }
        }
    }

    private void countBeverage(Map<String, Integer> orders) {
        for (Beverage beverage : Beverage.values()) {
            if (orders.containsKey(beverage.getName())) {
                menuType.put(BEVERAGE, menuType.get(BEVERAGE) + orders.get(beverage.getName()));
            }
        }
    }

    public boolean isOrderOnlyBeverage() {
        return (menuType.get(APPETIZER) == INITIAL_VALUE)
                && (menuType.get(MAIN) == INITIAL_VALUE)
                && (menuType.get(DESSERT) == INITIAL_VALUE);
    }

    public int calculateMenuTypeTotalCount() {
        int menuTypeTotalCount = 0;
        for (Map.Entry<String, Integer> entry : menuType.entrySet()) {
            menuTypeTotalCount += entry.getValue();
        }
        return menuTypeTotalCount;
    }
}
