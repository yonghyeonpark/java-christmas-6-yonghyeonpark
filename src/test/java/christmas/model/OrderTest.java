package christmas.model;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class OrderTest {

    @DisplayName("주문 메뉴에 대해 중복이 있으면 예외가 발생한다.")
    @Test
    void should_ThrowException_When_MenuDuplicate() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Order(List.of("티본스테이크-1", "티본스테이크-2", "양송이수프-1")))
                .withMessageContaining("[ERROR]");
    }

    @DisplayName("주문 메뉴의 총개수가 20을 넘으면 예외가 발생한다.")
    @Test
    void should_ThrowException_When_TotalMenuCountAboveTwenty() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Order(List.of("티본스테이크-18", "초코케이크-3")))
                .withMessageContaining("[ERROR]");
    }

    @DisplayName("주문 메뉴의 개별 개수가 1 미만이면 예외가 발생한다.")
    @Test
    void should_ThrowException_When_MenuCountUnderOne() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Order(List.of("티본스테이크-0")))
                .withMessageContaining("[ERROR]");
    }

    @DisplayName("주문 메뉴에 음료만 있으면 예외가 발생한다.")
    @Test
    void should_ThrowException_When_MenuTypeOnlyBeverage() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Order(List.of("제로콜라-1", "레드와인-3")))
                .withMessageContaining("[ERROR]");
    }

    @DisplayName("메뉴판에 없는 메뉴가 있으면 예외가 발생한다.")
    @Test
    void should_ThrowException_When_NotOnMenu() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Order(List.of("티본스테이크-2", "원할머니보쌈-3")))
                .withMessageContaining("[ERROR]");
    }
}
