package christmas.util;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import christmas.model.ErrorMessage;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class ConvertTest {

    @DisplayName("문자열을 정수로 변환하는 과정에서 공백이나 숫자가 아닌 입력이 있으면 예외가 발생한다.")
    @ParameterizedTest(name = "[테스트 케이스 {index}] 입력 값 : {arguments}")
    @ValueSource(strings = {"", "a"})
    void should_ThrowIllegalArgumentException_When_InputBlankOrNonInteger(String input) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Convert.stringToInteger(input, "[ERROR] content"));
    }

    @DisplayName("문자열을 쉼표 기준으로 분리하여 리스트에 저장한다.")
    @Test
    void stringToList() {
        String input = "타파스-1,제로콜라-1";
        List<String> list = Convert.stringToList(input);

        assertThat(list.size()).isEqualTo(2);
        assertThat(list.get(0)).isEqualTo("타파스-1");
        assertThat(list.get(1)).isEqualTo("제로콜라-1");
    }

    @DisplayName("주문리스트를 각각 메뉴와 수량으로 분리하여 Map에 저장한다.")
    @Test
    void listToMapWithSplit() {
        Map<String, Integer> orders = Convert.listToMapWithSplit(
                List.of("시저샐러드-1", "티본스테이크-2"),
                ErrorMessage.ORDER.getContent()
        );

        assertThat(orders.get("시저샐러드")).isEqualTo(1);
        assertThat(orders.get("티본스테이크")).isEqualTo(2);
    }
}
