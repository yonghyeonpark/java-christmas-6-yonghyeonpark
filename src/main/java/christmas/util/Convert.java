package christmas.util;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.List;

public class Convert {

    public static int stringToInteger(String input, String errorMessage) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(errorMessage);
        }
    }

    public static List<String> stringToListByComma(String input) {
        return Arrays.stream(input.split(","))
                .toList();
    }

    public static String formatIntegerToString(int amount) {
        DecimalFormat decimalFormat = new DecimalFormat("#,###");
        return decimalFormat.format(amount);
    }
}
