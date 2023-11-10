package christmas.util;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Convert {

    private static final String NON_INTEGER_INPUT_ERROR_MESSAGE = "[ERROR] 공백이나 숫자가 아닌 입력은 허용하지 않습니다. 다시 입력해 주세요.";

    public static int stringToInteger(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NON_INTEGER_INPUT_ERROR_MESSAGE);
        }
    }

    public static List<String> stringToList(String input) {
        return Arrays.stream(input.split(","))
                .collect(Collectors.toList());
    }

    public static Map<String, Integer> listToMapWithSplit(List<String> nonSplitOrders) {
        Map<String, Integer> orders = new HashMap<>();
        for (String nonSplitOrder : nonSplitOrders) {
            List<String> splitOrder = Arrays.stream(nonSplitOrder.split("-"))
                    .toList();
            orders.put(splitOrder.get(0), Convert.stringToInteger(splitOrder.get(1)));
        }
        return orders;
    }
}
