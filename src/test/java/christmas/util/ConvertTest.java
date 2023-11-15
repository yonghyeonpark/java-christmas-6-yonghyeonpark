package christmas.util;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class ConvertTest {

    @DisplayName("문자열을 정수로 변환한다.")
    @Test
    void stringToInteger() {
        String input = "5";
        String errorMessage = "[ERROR] 에러 메시지";

        int integer = Convert.stringToInteger(input, errorMessage);

        assertThat(integer).isEqualTo(5);
    }

    @DisplayName("문자열을 정수로 변환하는 과정에서 공백이나 숫자가 아닌 입력이 있으면 예외가 발생한다.")
    @ParameterizedTest(name = "[테스트 케이스 {index}] 입력 값 : {arguments}")
    @ValueSource(strings = {"", " ", "a"})
    void should_ThrowIllegalArgumentException_When_InputBlankOrNonInteger(String input) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Convert.stringToInteger(input, "[ERROR] content"));
    }

    @DisplayName("문자열을 쉼표 기준으로 분리하여 리스트에 저장한다.")
    @Test
    void stringToListByComma() {
        String input = "타파스-1,제로콜라-1";

        List<String> list = Convert.stringToListByComma(input);

        assertThat(list.size()).isEqualTo(2);
        assertThat(list.get(0)).isEqualTo("타파스-1");
        assertThat(list.get(1)).isEqualTo("제로콜라-1");
    }

    @DisplayName("문자열을 대시 기준으로 분리하여 리스트에 저장한다.")
    @Test
    void stringToListByDash() {
        String input = "양송이수프-2";

        List<String> list = Convert.stringToListByDash(input);

        assertThat(list.size()).isEqualTo(2);
        assertThat(list.get(0)).isEqualTo("양송이수프");
        assertThat(list.get(1)).isEqualTo("2");
    }

    @DisplayName("정수를 조건에 맞게 형식화하여 문자열로 변환한다.")
    @Test
    void formatIntegerToString() {
        int amount = 25000000;

        String formattedInteger = Convert.formatIntegerToString(amount);

        assertThat(formattedInteger).isEqualTo("25,000,000원");
    }
}
