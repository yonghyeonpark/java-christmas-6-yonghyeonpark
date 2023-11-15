package christmas.util;

import christmas.model.ErrorMessageType;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.List;

public class Convert {

    private static final String COMMA = ",";
    private static final String DASH = "-";
    private static final String AMOUNT_PATTERN = "#,###원";

    public static int stringToInteger(String input, String errorMessage) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(errorMessage);
        }
    }

    public static List<String> stringToListByComma(String input) {
        if (input.endsWith(COMMA)) {
            throw new IllegalArgumentException(ErrorMessageType.ORDER.getContent());
        }
        return Arrays.stream(input.split(COMMA))
                .toList();
    }

    public static List<String> stringToListByDash(String input) {
        return Arrays.stream(input.split(DASH))
                .toList();
    }

    public static String formatIntegerToString(int amount) {
        DecimalFormat decimalFormat = new DecimalFormat(AMOUNT_PATTERN);
        return decimalFormat.format(amount);
    }
}
