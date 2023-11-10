package christmas.model;

import christmas.util.Convert;
import java.util.List;
import java.util.Map;

public class Order {

    private static final String ORDER_INPUT_ERROR_MESSAGE = "[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.";

    private final Map<String, Integer> orders;

    public Order(List<String> orders) {
        Map<String, Integer> mappedOrders = Convert.listToMapWithSplit(orders);
        validateDuplicate(orders, mappedOrders);
        validateRange(mappedOrders);
        this.orders = mappedOrders;
    }

    private void validateDuplicate(List<String> orders, Map<String, Integer> mappedOrders) {
        if (orders.size() != mappedOrders.size()) {
            throw new IllegalArgumentException(ORDER_INPUT_ERROR_MESSAGE);
        }
    }

    private void validateRange(Map<String, Integer> orders) {
        int orderCount = 0;
        for (Map.Entry<String, Integer> entry : orders.entrySet()) {
            orderCount += entry.getValue();
        }
        if (orderCount > 20) {
            throw new IllegalArgumentException(ORDER_INPUT_ERROR_MESSAGE);
        }
    }
}
