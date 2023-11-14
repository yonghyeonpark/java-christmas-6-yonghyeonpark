package christmas.model;

import christmas.util.Convert;
import java.util.Map;

public class Benefit {

    private static final int INITIAL_AMOUNT = 0;
    private static final int NOTHING = -1;
    private static final int D_DAY_DISCOUNT_BASIC_AMOUNT = 1000;
    private static final int D_DAY_DISCOUNT_INCREMENT_AMOUNT = 100;
    private static final int WEEKDAY_AND_WEEKEND_DISCOUNT_AMOUNT_PER_MENU = 2023;
    private static final int SPECIAL_DAY_DISCOUNT_AMOUNT = 1000;

    private final Map<BenefitType, Integer> benefits;
    private final Date date;

    public Benefit(Map<BenefitType, Integer> benefits, Date date) {
        this.benefits = benefits;
        this.date = date;
        setUp();
    }

    private void setUp() {
        benefits.put(BenefitType.CHRISTMAS_D_DAY, INITIAL_AMOUNT);
        benefits.put(BenefitType.WEEKDAY, INITIAL_AMOUNT);
        benefits.put(BenefitType.WEEKEND, INITIAL_AMOUNT);
        benefits.put(BenefitType.SPECIAL, INITIAL_AMOUNT);
        benefits.put(BenefitType.GIFT_EVENT, INITIAL_AMOUNT);
    }

    public void calculateDDayDiscountAmount() {
        int calculation = date.CalculationForDDayDiscountAmount();
        if (calculation != NOTHING) {
            benefits.put(
                    BenefitType.CHRISTMAS_D_DAY,
                    D_DAY_DISCOUNT_BASIC_AMOUNT + (calculation * D_DAY_DISCOUNT_INCREMENT_AMOUNT)
            );
        }
    }

    public void calculateWeekDayOrWeekendDiscountAmount(Map<String, Integer> menuType) {
        if (date.judgeIsWeekdayOrWeekend().equals("weekday")) {
            benefits.put(BenefitType.WEEKDAY, menuType.get("디저트") * WEEKDAY_AND_WEEKEND_DISCOUNT_AMOUNT_PER_MENU);
        }
        if (date.judgeIsWeekdayOrWeekend().equals("weekend")) {
            benefits.put(BenefitType.WEEKEND, menuType.get("메인") * WEEKDAY_AND_WEEKEND_DISCOUNT_AMOUNT_PER_MENU);
        }
    }

    public void calculateSpecialDayDiscountAmount() {
        if (date.judgeIsSpecialDay().equals("specialDay")) {
            benefits.put(BenefitType.SPECIAL, SPECIAL_DAY_DISCOUNT_AMOUNT);
        }
    }

    public void calculateGiftEventDiscountAmount(String giftMenu) {
        if (giftMenu.equals("샴페인 1개")) {
            benefits.put(BenefitType.GIFT_EVENT, 25000);
        }
    }

    public int calculateTotalBenefitAmount() {
        int totalBenefitAmount = 0;
        for (Map.Entry<BenefitType, Integer> entry : benefits.entrySet()) {
            totalBenefitAmount += entry.getValue();
        }
        return totalBenefitAmount;
    }

    public int calculateTotalDiscountAmount() {
        int totalDiscountAmount = 0;
        for (Map.Entry<BenefitType, Integer> entry : benefits.entrySet()) {
            totalDiscountAmount += checkIsGiftEventType(entry);
        }
        return totalDiscountAmount;
    }

    private int checkIsGiftEventType(Map.Entry<BenefitType, Integer> entry) {
        if (!entry.getKey().equals(BenefitType.GIFT_EVENT)) {
            return entry.getValue();
        }
        return 0;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Map.Entry<BenefitType, Integer> entry : benefits.entrySet()) {
            if (entry.getValue() != 0) {
                stringBuilder.append(entry.getKey().getName())
                        .append(": ")
                        .append("-")
                        .append(Convert.formatIntegerToString(entry.getValue()))
                        .append("\n");
            }
        }
        return stringBuilder.toString();
    }
}
