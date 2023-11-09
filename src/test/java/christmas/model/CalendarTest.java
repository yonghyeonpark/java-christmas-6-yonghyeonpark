package christmas.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class CalendarTest {

    @DisplayName("날짜가 평일인지 주말인지 판단한다.")
    @ParameterizedTest(name = "[테스트 케이스 {index}] 날짜 : {0} -> {1}")
    @CsvSource({"4, weekday", "8, weekend"})
    void judgeIsWeekdayOrWeekend(int date, String day) {
        Calendar calendar = new Calendar(date);

        assertThat(calendar.judgeIsWeekdayOrWeekend()).isEqualTo(day);
    }
}
