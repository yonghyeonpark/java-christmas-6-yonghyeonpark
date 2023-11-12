package christmas.util;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Convert {

    public static int stringToInteger(String input, String errorMessage) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(errorMessage);
        }
    }

    public static List<String> stringToList(String input) {
        return Arrays.stream(input.split(","))
                .collect(Collectors.toList());
    }

    public static Map<String, Integer> listToMapWithSplit(List<String> nonSplitOrders, String errorMessage) {
        Map<String, Integer> orders = new HashMap<>();
        for (String nonSplitOrder : nonSplitOrders) {
            List<String> splitOrder = Arrays.stream(nonSplitOrder.split("-"))
                    .toList();
            orders.put(splitOrder.get(0), Convert.stringToInteger(splitOrder.get(1), errorMessage));
        }
        return orders;
    }
}
