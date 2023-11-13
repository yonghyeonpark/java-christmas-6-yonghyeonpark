package christmas.model;

import java.util.HashMap;
import java.util.Map;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class BenefitTest {

    @DisplayName("크리스마스 디데이 할인 금액을 계산한다.")
    @ParameterizedTest(name = "[테스트 케이스 {index}] 방문 날짜 : {0}일, 크리스마스 디데이 할인 금액 : {1}")
    @CsvSource({"1, 1000", "25, 3400"})
    void calculateDDayDiscountAmount(String date, int expected) {
        Map<BenefitType, Integer> benefits = new HashMap<>();
        Benefit benefit = new Benefit(benefits, new Calendar(date));

        benefit.calculateDDayDiscountAmount();

        Assertions.assertThat(benefits.get(BenefitType.CHRISTMAS_D_DAY)).isEqualTo(expected);
    }
}
