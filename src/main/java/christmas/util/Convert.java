package christmas.util;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Convert {

    private static final String NON_INTEGER_INPUT_ERROR_MESSAGE = "[ERROR] 공백이나 숫자가 아닌 입력은 허용하지 않습니다. 다시 입력해 주세요.";

    public static int StringToInteger(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NON_INTEGER_INPUT_ERROR_MESSAGE);
        }
    }

    public static List<String> StringToList(String input) {
        return Arrays.stream(input.split(","))
                .collect(Collectors.toList());
    }
}
