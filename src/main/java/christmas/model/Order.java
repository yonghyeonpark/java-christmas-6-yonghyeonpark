package christmas.model;

import christmas.util.Convert;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Order {

    private final Map<String, Integer> orders;

    public Order(Map<String, Integer> orders) {
        this.orders = orders;
    }

    public void setUp(List<String> nonSplitOrders) {
        for (String nonSplitOrder : nonSplitOrders) {
            List<String> splitOrder = Arrays.stream(nonSplitOrder.split("-"))
                    .toList();
            orders.put(splitOrder.get(0), Convert.StringToInteger(splitOrder.get(1)));
        }
    }
}
