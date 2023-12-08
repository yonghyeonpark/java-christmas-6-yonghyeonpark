package christmas.util;

import java.util.Arrays;
import java.util.List;

public class Convert {

    public static int stringToInt(String input, String errorMessage) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(errorMessage);
        }
    }

    public static List<String> stringToListByComma(String input, String errorMessage) {
        validateEndComma(input, errorMessage);
        return Arrays.stream(input.split(",")).toList();
    }

    private static void validateEndComma(String input, String errorMessage) {
        if (input.endsWith(",")) {
            throw new IllegalArgumentException(errorMessage);
        }
    }

    public static List<String> stringToListByDash(String input, String errorMessage) {
        validateEndDash(input, errorMessage);
        return Arrays.stream(input.split("-")).toList();
    }

    private static void validateEndDash(String input, String errorMessage) {
        if (input.endsWith("-")) {
            throw new IllegalArgumentException(errorMessage);
        }
    }
}
