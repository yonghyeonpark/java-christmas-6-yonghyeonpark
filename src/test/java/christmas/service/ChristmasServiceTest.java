package christmas.service;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class ChristmasServiceTest {

    @DisplayName("할인 전 총주문 금액에 따라 이벤트 적용 여부를 판단한다.")
    @ParameterizedTest(name = "[테스트 케이스 {index}] 총주문 금액 : {0}, 이벤트 적용 여부 : {1}")
    @CsvSource({"9999, false", "10000, true"})
    void isEventApplication(int totalOrderAmount, boolean expected) {
        ChristmasService christmasService = new ChristmasService();

        boolean eventApplication = christmasService.isEventApplication(totalOrderAmount);

        assertThat(eventApplication).isEqualTo(expected);
    }

    @DisplayName("할인 전 총주문 금액에 따라 증정 메뉴를 구한다.")
    @ParameterizedTest(name = "[테스트 케이스 {index}] 총주문 금액 : {0}, 증정 메뉴 : {1}")
    @CsvSource({"119999, 없음", "120000, 샴페인 1개"})
    void getGiftMenu(int totalOrderAmount, String expected) {
        ChristmasService christmasService = new ChristmasService();

        String giftMenu = christmasService.getGiftMenu(totalOrderAmount);

        assertThat(giftMenu).isEqualTo(expected);
    }

    @DisplayName("할인 후 예상 결제 금액을 계산한다.")
    @Test
    void calculatePaymentAmount() {
        ChristmasService christmasService = new ChristmasService();
        int totalOrderAmount = 30000;
        int totalDiscountAmount = 10000;

        int paymentAmount = christmasService.calculatePaymentAmount(totalOrderAmount, totalDiscountAmount);

        assertThat(paymentAmount).isEqualTo(20000);
    }
}
