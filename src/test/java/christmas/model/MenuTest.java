package christmas.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MenuTest {

    @DisplayName("주문에 대해 메뉴 종류를 분류하고 각 개수를 구한다.")
    @Test
    void countMenuType() {
        Map<String, Integer> menuType = new HashMap<>();
        Menu menu = new Menu(menuType);
        Map<String, Integer> orders = Map.of(
                "양송이수프", 1,
                "타파스", 2,
                "티본스테이크", 3,
                "아이스크림", 4,
                "레드와인", 5
        );

        menu.countMenuType(orders);

        assertThat(menuType.get("애피타이저")).isEqualTo(3);
        assertThat(menuType.get("메인")).isEqualTo(3);
        assertThat(menuType.get("디저트")).isEqualTo(4);
        assertThat(menuType.get("음료")).isEqualTo(5);
    }

    @DisplayName("주문에 음료만 있을 때, 메뉴 종류가 음료만 있는지 판단한다.")
    @Test
    void should_IsTrue_When_OrderOnlyBeverage() {
        Map<String, Integer> menuType = new HashMap<>();
        Menu menu = new Menu(menuType);
        Map<String, Integer> orders = Map.of(
                "제로콜라", 3,
                "레드와인", 5
        );
        menu.countMenuType(orders);

        boolean orderOnlyBeverage = menu.isOrderOnlyBeverage();

        assertThat(orderOnlyBeverage).isTrue();
    }

    @DisplayName("주문에 음료만 있지 않을 때, 메뉴 종류가 음료만 있는지 판단한다.")
    @Test
    void should_IsFalse_When_OrderNotOnlyBeverage() {
        Map<String, Integer> menuType = new HashMap<>();
        Menu menu = new Menu(menuType);
        Map<String, Integer> orders = Map.of(
                "양송이수프", 1,
                "타파스", 2,
                "티본스테이크", 3,
                "아이스크림", 4,
                "레드와인", 5
        );
        menu.countMenuType(orders);

        boolean orderOnlyBeverage = menu.isOrderOnlyBeverage();

        assertThat(orderOnlyBeverage).isFalse();
    }
}
