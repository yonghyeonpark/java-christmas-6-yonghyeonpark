package christmas.model;

import christmas.model.menu.Appetizer;
import christmas.model.menu.Beverage;
import christmas.model.menu.Dessert;
import christmas.model.menu.Main;
import christmas.util.Convert;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Order {

    private static final int ORDER_MENU = 0;
    private static final int ORDER_MENU_COUNT_STRING = 1;
    private static final int CORRECT_SPLIT_ORDER_SIZE = 2;
    private static final int MAX_MENU_ORDERS_COUNT = 20;
    private static final int MIN_MENU_ORDER_COUNT = 1;
    private static final String ORDER_INPUT_ERROR_MESSAGE = ErrorMessageType.ORDER.getContent();
    private static final String DASH = "-";
    private static final String SPACE = " ";
    private static final String COUNT_UNIT = "개";
    private static final String NEW_LINE = "\n";

    private final Map<String, Integer> orders;

    public Order(List<String> unorganizedOrders, Menu menu) {
        Map<String, Integer> orders = convertListToMapByDash(unorganizedOrders);
        validateDuplicate(unorganizedOrders, orders);
        validateTotalMenuCountRange(orders);
        validateMenuCountRange(orders);
        validateMenuType(orders, menu);
        validateMenu(orders, menu);
        this.orders = orders;
    }

    private Map<String, Integer> convertListToMapByDash(List<String> unorganizedOrders) {
        Map<String, Integer> orders = new HashMap<>();
        for (String unorganizedOrder : unorganizedOrders) {
            validateOrderEndChar(unorganizedOrder);
            List<String> splitUnorganizedOrder = Convert.stringToListByDash(unorganizedOrder);
            validateSplitOrderSize(splitUnorganizedOrder);
            orders.put(
                    splitUnorganizedOrder.get(ORDER_MENU),
                    Convert.stringToInteger(splitUnorganizedOrder.get(ORDER_MENU_COUNT_STRING),
                            ORDER_INPUT_ERROR_MESSAGE)
            );
        }
        return orders;
    }

    private void validateOrderEndChar(String unorganizedOrder) {
        if (unorganizedOrder.endsWith(DASH)) {
            throw new IllegalArgumentException(ORDER_INPUT_ERROR_MESSAGE);
        }
    }

    private void validateSplitOrderSize(List<String> splitUnorganizedOrder) {
        if (splitUnorganizedOrder.size() != CORRECT_SPLIT_ORDER_SIZE) {
            throw new IllegalArgumentException(ORDER_INPUT_ERROR_MESSAGE);
        }
    }

    private void validateDuplicate(List<String> unorganizedOrders, Map<String, Integer> orders) {
        if (unorganizedOrders.size() != orders.size()) {
            throw new IllegalArgumentException(ORDER_INPUT_ERROR_MESSAGE);
        }
    }

    private void validateTotalMenuCountRange(Map<String, Integer> orders) {
        if (calculateOrderCount(orders) > MAX_MENU_ORDERS_COUNT) {
            throw new IllegalArgumentException(ORDER_INPUT_ERROR_MESSAGE);
        }
    }

    private void validateMenuCountRange(Map<String, Integer> orders) {
        for (int orderCount : orders.values()) {
            checkMenuCountRange(orderCount);
        }
    }

    private void checkMenuCountRange(int orderCount) {
        if (orderCount < MIN_MENU_ORDER_COUNT) {
            throw new IllegalArgumentException(ORDER_INPUT_ERROR_MESSAGE);
        }
    }

    private void validateMenuType(Map<String, Integer> orders, Menu menu) {
        menu.countMenuType(orders);
        if (menu.isOrderOnlyBeverage()) {
            throw new IllegalArgumentException(ORDER_INPUT_ERROR_MESSAGE);
        }
    }

    private void validateMenu(Map<String, Integer> orders, Menu menu) {
        if (calculateOrderCount(orders) != menu.calculateMenuTypeTotalCount()) {
            throw new IllegalArgumentException(ORDER_INPUT_ERROR_MESSAGE);
        }
    }

    private int calculateOrderCount(Map<String, Integer> orders) {
        int orderCount = 0;
        for (Map.Entry<String, Integer> entry : orders.entrySet()) {
            orderCount += entry.getValue();
        }
        return orderCount;
    }

    public int calculateTotalOrderAmount() {
        int totalOrderAmount = 0;
        for (Map.Entry<String, Integer> entry : orders.entrySet()) {
            totalOrderAmount += calculateOrderAmountByMenuType(entry);
        }
        return totalOrderAmount;
    }

    private int calculateOrderAmountByMenuType(Map.Entry<String, Integer> entry) {
        return calculateAppetizerOrderAmount(entry)
                + calculateMainOrderAmount(entry)
                + calculateDessertOrderAmount(entry)
                + calculateBeverageOrderAmount(entry);
    }

    private int calculateAppetizerOrderAmount(Map.Entry<String, Integer> entry) {
        int appetizerOrderAmount = 0;
        for (Appetizer appetizer : Appetizer.values()) {
            if (entry.getKey().equals(appetizer.getName())) {
                appetizerOrderAmount += (entry.getValue()) * (appetizer.getPrice());
            }
        }
        return appetizerOrderAmount;
    }

    private int calculateMainOrderAmount(Map.Entry<String, Integer> entry) {
        int mainOrderAmount = 0;
        for (Main main : Main.values()) {
            if (entry.getKey().equals(main.getName())) {
                mainOrderAmount += (entry.getValue()) * (main.getPrice());
            }
        }
        return mainOrderAmount;
    }

    private int calculateDessertOrderAmount(Map.Entry<String, Integer> entry) {
        int dessertOrderAmount = 0;
        for (Dessert dessert : Dessert.values()) {
            if (entry.getKey().equals(dessert.getName())) {
                dessertOrderAmount += (entry.getValue()) * (dessert.getPrice());
            }
        }
        return dessertOrderAmount;
    }

    private int calculateBeverageOrderAmount(Map.Entry<String, Integer> entry) {
        int beverageOrderAmount = 0;
        for (Beverage beverage : Beverage.values()) {
            if (entry.getKey().equals(beverage.getName())) {
                beverageOrderAmount += (entry.getValue()) * (beverage.getPrice());
            }
        }
        return beverageOrderAmount;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Map.Entry<String, Integer> entry : orders.entrySet()) {
            stringBuilder.append(entry.getKey())
                    .append(SPACE)
                    .append(entry.getValue())
                    .append(COUNT_UNIT)
                    .append(NEW_LINE);
        }
        return stringBuilder.toString();
    }
}
