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

    private static final int MIN_ORDER_COUNT = 1;
    private static final int MAX_ORDERS_COUNT = 20;
    private static final String ORDER_ERROR_MESSAGE = "[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.";
    private static final String BLANK = " ";
    private static final String UNIT = "개";
    private static final String NEW_LINE = "\n";

    private final Map<String, Integer> orders;

    public Order(String inputOrders) {
        this.orders = new HashMap<>();
        setUp(inputOrders);
        validateCount();
        validateOnlyBeverage();
    }

    private void setUp(String inputOrders) {
        List<String> orders = Convert.stringToListByComma(inputOrders, ORDER_ERROR_MESSAGE);
        for (String order : orders) {
            List<String> menuAndCount = Convert.stringToListByDash(order, ORDER_ERROR_MESSAGE);
            validateFormat(menuAndCount);
            this.orders.put(menuAndCount.get(0), Convert.stringToInt(menuAndCount.get(1), ORDER_ERROR_MESSAGE));
        }
        validateDuplicate(orders);
        validateMenu(orders);
    }

    private void validateFormat(List<String> menuAndCount) {
        if (menuAndCount.size() != 2) {
            throw new IllegalArgumentException(ORDER_ERROR_MESSAGE);
        }
    }

    private void validateDuplicate(List<String> orders) {
        if (this.orders.size() != orders.size()) {
            throw new IllegalArgumentException(ORDER_ERROR_MESSAGE);
        }
    }

    private void validateMenu(List<String> orders) {
        int menuTypeCount = 0;
        for (Map.Entry<String, Integer> entry : this.orders.entrySet()) {
            menuTypeCount += getAppetizerCount(entry);
            menuTypeCount += getMainDishCount(entry);
            menuTypeCount += getDessertCount(entry);
            menuTypeCount += getBeverageCount(entry);
        }
        if (orders.size() != menuTypeCount) {
            throw new IllegalArgumentException(ORDER_ERROR_MESSAGE);
        }
    }

    private int getAppetizerCount(Map.Entry<String, Integer> entry) {
        int appetizerCount = 0;
        for (Appetizer appetizer : Appetizer.values()) {
            if (entry.getKey().contains(appetizer.getName())) {
                appetizerCount++;
            }
        }
        return appetizerCount;
    }

    private int getMainDishCount(Map.Entry<String, Integer> entry) {
        int mainDishCount = 0;
        for (MainDish mainDish : MainDish.values()) {
            if (entry.getKey().contains(mainDish.getName())) {
                mainDishCount++;
            }
        }
        return mainDishCount;
    }

    private int getDessertCount(Map.Entry<String, Integer> entry) {
        int DessertCount = 0;
        for (Dessert dessert : Dessert.values()) {
            if (entry.getKey().contains(dessert.getName())) {
                DessertCount++;
            }
        }
        return DessertCount;
    }

    private int getBeverageCount(Map.Entry<String, Integer> entry) {
        int beverageCount = 0;
        for (Beverage beverage : Beverage.values()) {
            if (entry.getKey().contains(beverage.getName())) {
                beverageCount++;
            }
        }
        return beverageCount;
    }


    private void validateCount() {
        int totalCount = 0;
        for (int count : orders.values()) {
            if (count < MIN_ORDER_COUNT) {
                throw new IllegalArgumentException(ORDER_ERROR_MESSAGE);
            }
            totalCount += count;
        }
        if (totalCount > MAX_ORDERS_COUNT) {
            throw new IllegalArgumentException(ORDER_ERROR_MESSAGE);
        }
    }

    private void validateOnlyBeverage() {
        int beverageCount = 0;
        for (Beverage beverage : Beverage.values()) {
            if (orders.containsKey(beverage.getName())) {
                beverageCount++;
            }
        }
        if (beverageCount == orders.size()) {
            throw new IllegalArgumentException(ORDER_ERROR_MESSAGE);
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
