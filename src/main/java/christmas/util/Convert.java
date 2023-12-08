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

    public static List<String> stringToListByComma(String input) {
        return Arrays.stream(input.split(",")).toList();
    }

    public static List<String> stringToListByDash(String input) {
        return Arrays.stream(input.split("-")).toList();
    }
}
