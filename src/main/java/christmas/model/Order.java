package christmas.model;

import java.util.Map;

public class Order {

    private final Map<String, Integer> orders;

    public Order(Map<String, Integer> orders) {
        this.orders = orders;
    }
}
