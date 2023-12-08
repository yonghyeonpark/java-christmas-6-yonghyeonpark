package christmas.domain;

import christmas.domain.menu.Beverage;

public class Benefit {

    private static final int D_DAY_DISCOUNT_BASIC_AMOUNT = 1000;
    private static final int D_DAY_DISCOUNT_ADDITIONAL_AMOUNT = 100;
    private static final int WEEKDAY_DISCOUNT_AMOUNT = 2023;
    private static final int WEEKEND_DISCOUNT_AMOUNT = 2023;
    private static final int SPECIAL_DAY_DISCOUNT_AMOUNT = 1000;
    private static final int GIFT_EVENT_APPLICATION_CRITERIA = 120000;

    private final Date date;
    private final Order order;

    public Benefit(Date date, Order order) {
        this.date = date;
        this.order = order;
    }

    public int calculateTotalAmount() {
        int totalAmount = 0;
        totalAmount += calculateDDayDiscountAmount();
        totalAmount += calculateWeekEndOrWeekDayDiscountAmount();
        totalAmount += calculateSpecialDayDiscountAmount();
        totalAmount += calculateGiftEventAmount();
        return totalAmount;
    }

    private int calculateDDayDiscountAmount() {
        if (date.isOverChristmas()) {
            return 0;
        }
        return D_DAY_DISCOUNT_BASIC_AMOUNT + ((date.getDate() - 1) * D_DAY_DISCOUNT_ADDITIONAL_AMOUNT);
    }

    private int calculateWeekEndOrWeekDayDiscountAmount() {
        int mainDishCount = order.countMainDish();
        if (date.isWeekEnd()) {
            return mainDishCount * WEEKEND_DISCOUNT_AMOUNT;
        }
        int dessertCount = order.countDessert();
        return dessertCount * WEEKDAY_DISCOUNT_AMOUNT;
    }

    private int calculateSpecialDayDiscountAmount() {
        if (date.isSpecialDay()) {
            return SPECIAL_DAY_DISCOUNT_AMOUNT;
        }
        return 0;
    }

    private int calculateGiftEventAmount() {
        if (order.calculateTotalAmount() > GIFT_EVENT_APPLICATION_CRITERIA) {
            return Beverage.CHAMPAGNE.getPrice();
        }
        return 0;
    }
}
