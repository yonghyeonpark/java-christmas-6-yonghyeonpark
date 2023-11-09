package christmas.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class OrderTest {

    @DisplayName("주문리스트를 각각 메뉴와 수량으로 나누어 Map에 저장한다.")
    @Test
    void ordersSetUp() {
        Map<String, Integer> orders = new HashMap<>();
        Order order = new Order(orders);
        order.setUp(List.of("시저샐러드-1", "티본스테이크-2"));

        assertThat(orders.get("시저샐러드")).isEqualTo(1);
        assertThat(orders.get("티본스테이크")).isEqualTo(2);
    }
}
