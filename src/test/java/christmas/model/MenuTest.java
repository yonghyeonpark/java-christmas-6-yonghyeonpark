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
        menu.countMenuType(Map.of(
                "양송이수프", 1,
                "타파스", 2,
                "티본스테이크", 3,
                "아이스크림", 4,
                "레드와인", 5
        ));

        assertThat(menuType.get("애피타이저")).isEqualTo(3);
        assertThat(menuType.get("메인")).isEqualTo(3);
        assertThat(menuType.get("디저트")).isEqualTo(4);
        assertThat(menuType.get("음료")).isEqualTo(5);
    }
}
