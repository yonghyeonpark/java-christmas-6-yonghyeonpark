package christmas.domain;

import christmas.util.Convert;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Order {

    private static final String ORDER_ERROR_MESSAGE = "[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.";

    private final Map<String, Integer> orders;

    public Order(String inputOrders) {
        this.orders = new HashMap<>();
        setUp(inputOrders);
    }

    private void setUp(String inputOrders) {
        List<String> orders = Convert.stringToListByComma(inputOrders);
        for (String order : orders) {
            List<String> menuAndCount = Convert.stringToListByDash(order);
            this.orders.put(menuAndCount.get(0), Convert.stringToInt(menuAndCount.get(1), ORDER_ERROR_MESSAGE));
        }
    }
}
