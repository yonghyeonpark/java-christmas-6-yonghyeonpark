package christmas.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
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

        assertThat(benefits.get(BenefitType.CHRISTMAS_D_DAY)).isEqualTo(expected);
    }

    @DisplayName("평일 할인 금액을 계산한다.")
    @Test
    void calculateWeekDayDiscountAmount() {
        Map<BenefitType, Integer> benefits = new HashMap<>();
        Benefit benefit = new Benefit(benefits, new Calendar("17"));
        Map<String, Integer> menuType = new HashMap<>();
        menuType.put("메인", 2);
        menuType.put("디저트", 3);

        benefit.calculateWeekDayOrWeekendDiscountAmount(menuType);

        assertThat(benefits.get(BenefitType.WEEKDAY)).isEqualTo(6069);
        assertThat(benefits.get(BenefitType.WEEKEND)).isEqualTo(0);
    }

    @DisplayName("주말 할인 금액을 계산한다.")
    @Test
    void calculateWeekendDiscountAmount() {
        Map<BenefitType, Integer> benefits = new HashMap<>();
        Benefit benefit = new Benefit(benefits, new Calendar("15"));
        Map<String, Integer> menuType = new HashMap<>();
        menuType.put("메인", 2);
        menuType.put("디저트", 3);

        benefit.calculateWeekDayOrWeekendDiscountAmount(menuType);

        assertThat(benefits.get(BenefitType.WEEKDAY)).isEqualTo(0);
        assertThat(benefits.get(BenefitType.WEEKEND)).isEqualTo(4046);
    }
}
