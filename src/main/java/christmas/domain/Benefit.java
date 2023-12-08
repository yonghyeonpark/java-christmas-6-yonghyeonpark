package christmas.domain;

import christmas.domain.menu.Beverage;
import java.text.DecimalFormat;

public class Benefit {

    private static final int D_DAY_DISCOUNT_BASIC_AMOUNT = 1000;
    private static final int D_DAY_DISCOUNT_ADDITIONAL_AMOUNT = 100;
    private static final int WEEKDAY_DISCOUNT_AMOUNT = 2023;
    private static final int WEEKEND_DISCOUNT_AMOUNT = 2023;
    private static final int SPECIAL_DAY_DISCOUNT_AMOUNT = 1000;
    private static final int GIFT_EVENT_APPLICATION_CRITERIA = 120000;
    private static final String NEW_LINE = "\n";
    private static final String D_DAY_DISCOUNT_FORMAT = "크리스마스 디데이 할인: ";
    private static final String WEEKDAY_DISCOUNT_FORMAT = "평일 할인: ";
    private static final String WEEKEND_DISCOUNT_FORMAT = "주말 할인: ";
    private static final String SPECIAL_DISCOUNT_FORMAT = "특별 할인: ";
    private static final String GIFT_EVENT_FORMAT = "증정 이벤트: ";

    private final Date date;
    private final Order order;

    public Benefit(Date date, Order order) {
        this.date = date;
        this.order = order;
    }

    public int calculateTotalAmount() {
        int totalAmount = 0;
        totalAmount += calculateDDayDiscountAmount();
        totalAmount += calculateWeekDayDiscountAmount();
        totalAmount += calculateWeekEndDiscountAmount();
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

    private int calculateWeekDayDiscountAmount() {
        int dessertCount = order.countDessert();
        if (!date.isWeekEnd()) {
            return dessertCount * WEEKDAY_DISCOUNT_AMOUNT;
        }
        return 0;
    }

    private int calculateWeekEndDiscountAmount() {
        int mainDishCount = order.countMainDish();
        if (date.isWeekEnd()) {
            return mainDishCount * WEEKEND_DISCOUNT_AMOUNT;
        }
        return 0;
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

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        DecimalFormat decimalFormat = new DecimalFormat("-#,###원");
        hasDDayDiscount(stringBuilder, decimalFormat);
        hasWeekDayDiscount(stringBuilder, decimalFormat);
        hasWeekEndDiscount(stringBuilder, decimalFormat);
        hasSpecialDayDiscount(stringBuilder, decimalFormat);
        hasGiftEvent(stringBuilder, decimalFormat);
        return stringBuilder.toString();
    }

    private void hasDDayDiscount(StringBuilder stringBuilder, DecimalFormat decimalFormat) {
        if (calculateDDayDiscountAmount() != 0) {
            stringBuilder.append(D_DAY_DISCOUNT_FORMAT)
                    .append(decimalFormat.format(calculateDDayDiscountAmount()))
                    .append(NEW_LINE);
        }
    }

    private void hasWeekDayDiscount(StringBuilder stringBuilder, DecimalFormat decimalFormat) {
        if (calculateWeekDayDiscountAmount() != 0) {
            stringBuilder.append(WEEKDAY_DISCOUNT_FORMAT)
                    .append(decimalFormat.format(calculateWeekDayDiscountAmount()))
                    .append(NEW_LINE);
        }
    }

    private void hasWeekEndDiscount(StringBuilder stringBuilder, DecimalFormat decimalFormat) {
        if (calculateWeekEndDiscountAmount() != 0) {
            stringBuilder.append(WEEKEND_DISCOUNT_FORMAT)
                    .append(decimalFormat.format(calculateWeekEndDiscountAmount()))
                    .append(NEW_LINE);
        }
    }

    private void hasSpecialDayDiscount(StringBuilder stringBuilder, DecimalFormat decimalFormat) {
        if (calculateSpecialDayDiscountAmount() != 0) {
            stringBuilder.append(SPECIAL_DISCOUNT_FORMAT)
                    .append(decimalFormat.format(calculateSpecialDayDiscountAmount()))
                    .append(NEW_LINE);
        }
    }

    private void hasGiftEvent(StringBuilder stringBuilder, DecimalFormat decimalFormat) {
        if (calculateGiftEventAmount() != 0) {
            stringBuilder.append(GIFT_EVENT_FORMAT)
                    .append(decimalFormat.format(calculateGiftEventAmount()));
        }
    }
}
