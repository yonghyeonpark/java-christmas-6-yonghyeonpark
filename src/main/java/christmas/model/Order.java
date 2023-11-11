package christmas.model;

import christmas.util.Convert;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Order {

    private static final String ORDER_INPUT_ERROR_MESSAGE = "[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.";

    private final Map<String, Integer> orders;

    public Order(List<String> orders) {
        Map<String, Integer> mappedOrders = Convert.listToMapWithSplit(orders);
        validateDuplicate(orders, mappedOrders);
        validateTotalMenuCountRange(mappedOrders);
        validateMenuCountRange(mappedOrders);
        MenuType menuType = new MenuType(new HashMap<>());
        validateMenuType(mappedOrders, menuType);
        validateMenu(mappedOrders, menuType);
        this.orders = mappedOrders;
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
}
