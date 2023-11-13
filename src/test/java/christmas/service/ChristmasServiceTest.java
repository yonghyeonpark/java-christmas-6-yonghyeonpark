package christmas.service;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
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
}
