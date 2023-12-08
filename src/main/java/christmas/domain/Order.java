package christmas.domain;

import christmas.domain.menu.Appetizer;
import christmas.domain.menu.Beverage;
import christmas.domain.menu.Dessert;
import christmas.domain.menu.MainDish;
import christmas.util.Convert;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Order {

    private static final String ORDER_ERROR_MESSAGE = "[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.";
    private static final String BLANK = " ";
    private static final String UNIT = "개";
    private static final String NEW_LINE = "\n";

    private final Map<String, Integer> orders;

    public Order(String inputOrders) {
        this.orders = new HashMap<>();
        setUp(inputOrders);
    }

    private void setUp(String inputOrders) {
        List<String> orders = Convert.stringToListByComma(inputOrders);
        for (String order : orders) {
            List<String> menuAndCount = Convert.stringToListByDash(order);
            this.orders.put(menuAndCount.get(0), Convert.stringToInt(menuAndCount.get(1), ORDER_ERROR_MESSAGE));
        }
    }

    public int countDessert() {
        int dessertCount = 0;
        for (Dessert dessert : Dessert.values()) {
            if (orders.containsKey(dessert.getName())) {
                dessertCount += orders.get(dessert.getName());
            }
        }
        return dessertCount;
    }

    public int countMainDish() {
        int mainDishCount = 0;
        for (MainDish mainDish : MainDish.values()) {
            if (orders.containsKey(mainDish.getName())) {
                mainDishCount += orders.get(mainDish.getName());
            }
        }
        return mainDishCount;
    }

    public int calculateTotalAmount() {
        int totalAmount = 0;
        for (Map.Entry<String, Integer> entry : orders.entrySet()) {
            totalAmount += checkAppetizer(entry);
            totalAmount += checkMainDish(entry);
            totalAmount += checkDessert(entry);
            totalAmount += checkBeverage(entry);
        }
        return totalAmount;
    }

    private int checkAppetizer(Map.Entry<String, Integer> entry) {
        int appetizerAmount = 0;
        for (Appetizer appetizer : Appetizer.values()) {
            if (entry.getKey().equals(appetizer.getName())) {
                appetizerAmount += entry.getValue() * appetizer.getPrice();
            }
        }
        return appetizerAmount;
    }

    private int checkMainDish(Map.Entry<String, Integer> entry) {
        int mainDishAmount = 0;
        for (MainDish mainDish : MainDish.values()) {
            if (entry.getKey().equals(mainDish.getName())) {
                mainDishAmount += entry.getValue() * mainDish.getPrice();
            }
        }
        return mainDishAmount;
    }

    private int checkDessert(Map.Entry<String, Integer> entry) {
        int dessertAmount = 0;
        for (Dessert dessert : Dessert.values()) {
            if (entry.getKey().equals(dessert.getName())) {
                dessertAmount += entry.getValue() * dessert.getPrice();
            }
        }
        return dessertAmount;
    }

    private int checkBeverage(Map.Entry<String, Integer> entry) {
        int beverageAmount = 0;
        for (Beverage beverage : Beverage.values()) {
            if (entry.getKey().equals(beverage.getName())) {
                beverageAmount += entry.getValue() * beverage.getPrice();
            }
        }
        return beverageAmount;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Map.Entry<String, Integer> entry : orders.entrySet()) {
            stringBuilder.append(entry.getKey())
                    .append(BLANK)
                    .append(entry.getValue())
                    .append(UNIT)
                    .append(NEW_LINE);
        }
        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        return stringBuilder.toString();
    }
}
