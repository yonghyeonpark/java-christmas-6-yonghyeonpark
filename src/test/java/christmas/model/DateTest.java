package christmas.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class DateTest {

    @DisplayName("날짜가 평일인지 주말인지 판단한다.")
    @ParameterizedTest(name = "[테스트 케이스 {index}] 날짜 : {0} -> {1}")
    @CsvSource({"4, weekday", "8, weekend"})
    void judgeIsWeekdayOrWeekend(String inputDate, String day) {
        Date date = new Date(inputDate);

        assertThat(date.judgeIsWeekdayOrWeekend()).isEqualTo(day);
    }

    @DisplayName("날짜가 특별한 날인지 판단한다.")
    @Test
    void judgeIsSpecialDay() {
        String inputDate = "10";

        Date date = new Date(inputDate);

        assertThat(date.judgeIsSpecialDay()).isEqualTo("specialDay");
    }

    @DisplayName("입력 날짜가 1 미만이거나 31 초과면 예외가 발생한다.")
    @ParameterizedTest(name = "[테스트 케이스 {index}] 입력 날짜 : {arguments}")
    @ValueSource(strings = {"0", "32"})
    void should_ThrowException_When_UnderOneOrAboveThirtyOne(String inputDate) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Date(inputDate))
                .withMessageContaining("[ERROR]");
    }
}
