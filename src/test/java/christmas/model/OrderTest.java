package christmas.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import java.util.HashMap;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class OrderTest {

    private MenuType menuType;

    @BeforeEach
    void setUp() {
        menuType = new MenuType(new HashMap<>());
    }

    @DisplayName("주문 메뉴에 대해 중복이 있으면 예외가 발생한다.")
    @Test
    void should_ThrowException_When_MenuDuplicate() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Order(List.of("티본스테이크-1", "티본스테이크-2", "양송이수프-1"), menuType))
                .withMessageContaining("[ERROR]");
    }

    @DisplayName("주문 메뉴의 총개수가 20을 넘으면 예외가 발생한다.")
    @Test
    void should_ThrowException_When_TotalMenuCountAboveTwenty() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Order(List.of("티본스테이크-18", "초코케이크-3"), menuType))
                .withMessageContaining("[ERROR]");
    }

    @DisplayName("주문 메뉴의 개별 개수가 1 미만이면 예외가 발생한다.")
    @Test
    void should_ThrowException_When_MenuCountUnderOne() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Order(List.of("티본스테이크-0"), menuType))
                .withMessageContaining("[ERROR]");
    }

    @DisplayName("주문 메뉴에 음료만 있으면 예외가 발생한다.")
    @Test
    void should_ThrowException_When_MenuTypeOnlyBeverage() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Order(List.of("제로콜라-1", "레드와인-3"), menuType))
                .withMessageContaining("[ERROR]");
    }

    @DisplayName("메뉴판에 없는 메뉴가 있으면 예외가 발생한다.")
    @Test
    void should_ThrowException_When_NotOnMenu() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Order(List.of("티본스테이크-2", "원할머니보쌈-3"), menuType))
                .withMessageContaining("[ERROR]");
    }

    @DisplayName("주문이 잘못된 형식으로 입력되면 예외가 발생한다.")
    @Nested
    class FormatError {

        @DisplayName("예시 : (-티본스테이크-2,아이스크림-4)")
        @Test
        void ex1_should_ThrowException_When_FormatError() {
            assertThatIllegalArgumentException()
                    .isThrownBy(() -> new Order(List.of("-티본스테이크-2", "아이스크림-4"), menuType))
                    .withMessageContaining("[ERROR]");
        }

        @DisplayName("예시 : (티본스테이크-2-,아이스크림-4)")
        @Test
        void ex2_should_ThrowException_When_FormatError() {
            assertThatIllegalArgumentException()
                    .isThrownBy(() -> new Order(List.of("티본스테이크-2-", "아이스크림-4"), menuType))
                    .withMessageContaining("[ERROR]");
        }

        @DisplayName("예시 : (티본스테이크-2-3,아이스크림-4)")
        @Test
        void ex3_should_ThrowException_When_FormatError() {
            assertThatIllegalArgumentException()
                    .isThrownBy(() -> new Order(List.of("티본스테이크-2-3", "아이스크림-4"), menuType))
                    .withMessageContaining("[ERROR]");
        }

        @DisplayName("예시 : (티본스테이크-2- ,아이스크림-4)")
        @Test
        void ex4_should_ThrowException_When_FormatError() {
            assertThatIllegalArgumentException()
                    .isThrownBy(() -> new Order(List.of("티본스테이크-2- ", "아이스크림-4"), menuType))
                    .withMessageContaining("[ERROR]");
        }

        @DisplayName("예시 : (티본스테이크-2,4)")
        @Test
        void ex5_should_ThrowException_When_FormatError() {
            assertThatIllegalArgumentException()
                    .isThrownBy(() -> new Order(List.of("티본스테이크-2", "4"), menuType))
                    .withMessageContaining("[ERROR]");
        }

        @DisplayName("예시 : (티본스테이크-2,아이스크림)")
        @Test
        void ex6_should_ThrowException_When_FormatError() {
            assertThatIllegalArgumentException()
                    .isThrownBy(() -> new Order(List.of("티본스테이크-2", "아이스크림"), menuType))
                    .withMessageContaining("[ERROR]");
        }
    }

    @DisplayName("총주문 금액을 구한다.")
    @Test
    void calculateTotalOrderAmount() {
        Order order = new Order(List.of("양송이수프-2", "티본스테이크-2", "레드와인-2", "아이스크림-2"), menuType);
        int totalOrderAmount = order.calculateTotalOrderAmount();

        assertThat(totalOrderAmount).isEqualTo(252000);
    }
}
