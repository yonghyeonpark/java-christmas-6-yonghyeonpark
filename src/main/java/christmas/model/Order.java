package christmas.model;

import christmas.model.menu.Appetizer;
import christmas.model.menu.Beverage;
import christmas.model.menu.Dessert;
import christmas.model.menu.Main;
import christmas.util.Convert;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Order {

    private static final String ORDER_INPUT_ERROR_MESSAGE = ErrorMessage.ORDER.getContent();

    private final Map<String, Integer> orders;

    public Order(List<String> orders) {
        Map<String, Integer> mappedOrders = convertListToMapByDash(orders);
        validateDuplicate(orders, mappedOrders);
        validateTotalMenuCountRange(mappedOrders);
        validateMenuCountRange(mappedOrders);
        MenuType menuType = new MenuType(new HashMap<>());
        validateMenuType(mappedOrders, menuType);
        validateMenu(mappedOrders, menuType);
        this.orders = mappedOrders;
    }

    private Map<String, Integer> convertListToMapByDash(List<String> orders) {
        Map<String, Integer> mappedOrders = new HashMap<>();
        for (String order : orders) {
            validateOrderEndChar(order);
            List<String> splitOrder = Arrays.stream(order.split("-"))
                    .toList();
            validateSplitOrderSize(splitOrder);
            mappedOrders.put(
                    splitOrder.get(0),
                    Convert.stringToInteger(splitOrder.get(1), ORDER_INPUT_ERROR_MESSAGE)
            );
        }
        return mappedOrders;
    }

    private void validateOrderEndChar(String order) {
        if (order.endsWith("-")) {
            throw new IllegalArgumentException(ORDER_INPUT_ERROR_MESSAGE);
        }
    }

    private void validateSplitOrderSize(List<String> splitOrder) {
        if (splitOrder.size() != 2) {
            throw new IllegalArgumentException(ORDER_INPUT_ERROR_MESSAGE);
        }
    }

    private void validateDuplicate(List<String> orders, Map<String, Integer> mappedOrders) {
        if (orders.size() != mappedOrders.size()) {
            throw new IllegalArgumentException(ORDER_INPUT_ERROR_MESSAGE);
        }
    }

    private void validateTotalMenuCountRange(Map<String, Integer> orders) {
        if (getOrderCount(orders) > 20) {
            throw new IllegalArgumentException(ORDER_INPUT_ERROR_MESSAGE);
        }
    }

    private void validateMenuCountRange(Map<String, Integer> orders) {
        for (int orderCount : orders.values()) {
            checkMenuCountRange(orderCount);
        }
    }

    private void checkMenuCountRange(int orderCount) {
        if (orderCount < 1) {
            throw new IllegalArgumentException(ORDER_INPUT_ERROR_MESSAGE);
        }
    }

    private void validateMenuType(Map<String, Integer> orders, MenuType menuType) {
        menuType.countMenuType(orders);
        if (menuType.isOrderOnlyBeverage()) {
            throw new IllegalArgumentException(ORDER_INPUT_ERROR_MESSAGE);
        }
    }

    private void validateMenu(Map<String, Integer> orders, MenuType menuType) {
        if (getOrderCount(orders) != menuType.getMenuTypeTotalCount()) {
            throw new IllegalArgumentException(ORDER_INPUT_ERROR_MESSAGE);
        }
    }

    private int getOrderCount(Map<String, Integer> orders) {
        int orderCount = 0;
        for (Map.Entry<String, Integer> entry : orders.entrySet()) {
            orderCount += entry.getValue();
        }
        return orderCount;
    }

    public int calculateTotalOrderAmount() {
        int totalOrderAmount = 0;
        for (Map.Entry<String, Integer> entry : orders.entrySet()) {
            totalOrderAmount += orderAmountByMenuType(entry);
        }
        return totalOrderAmount;
    }

    private int orderAmountByMenuType(Map.Entry<String, Integer> entry) {
        int ordersAmount = 0;
        ordersAmount += appetizerOrderAmount(entry);
        ordersAmount += mainOrderAmount(entry);
        ordersAmount += dessertOrderAmount(entry);
        ordersAmount += beverageOrderAmount(entry);
        return ordersAmount;
    }

    private int appetizerOrderAmount(Map.Entry<String, Integer> entry) {
        int appetizerOrderAmount = 0;
        for (Appetizer appetizer : Appetizer.values()) {
            if (entry.getKey().equals(appetizer.getName())) {
                appetizerOrderAmount += (entry.getValue()) * (appetizer.getPrice());
            }
        }
        return appetizerOrderAmount;
    }

    private int mainOrderAmount(Map.Entry<String, Integer> entry) {
        int mainOrderAmount = 0;
        for (Main main : Main.values()) {
            if (entry.getKey().equals(main.getName())) {
                mainOrderAmount += (entry.getValue()) * (main.getPrice());
            }
        }
        return mainOrderAmount;
    }

    private int dessertOrderAmount(Map.Entry<String, Integer> entry) {
        int dessertOrderAmount = 0;
        for (Dessert dessert : Dessert.values()) {
            if (entry.getKey().equals(dessert.getName())) {
                dessertOrderAmount += (entry.getValue()) * (dessert.getPrice());
            }
        }
        return dessertOrderAmount;
    }

    private int beverageOrderAmount(Map.Entry<String, Integer> entry) {
        int beverageOrderAmount = 0;
        for (Beverage beverage : Beverage.values()) {
            if (entry.getKey().equals(beverage.getName())) {
                beverageOrderAmount += (entry.getValue()) * (beverage.getPrice());
            }
        }
        return beverageOrderAmount;
    }
}
