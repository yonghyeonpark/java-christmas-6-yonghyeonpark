package christmas.util;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class ConvertTest {

    @DisplayName("문자열을 정수로 변환하는 과정에서 공백이나 숫자가 아닌 입력이 있으면 예외가 발생한다.")
    @ParameterizedTest(name = "[테스트 케이스 {index}] 입력 값 : {arguments}")
    @ValueSource(strings = {"", "a"})
    void should_ThrowIllegalArgumentException_When_InputBlankOrNonInteger(String input) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Convert.StringToInteger(input))
                .withMessageContaining("[ERROR]");
    }
}
