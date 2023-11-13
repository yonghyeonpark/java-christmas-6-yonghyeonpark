package christmas.model;

import java.util.Map;

public class Benefit {

    private static final int INITIAL_AMOUNT = 0;
    private static final int NOTHING = -1;
    private static final int D_DAY_DISCOUNT_BASIC_AMOUNT = 1000;
    private static final int D_DAY_DISCOUNT_INCREMENT_AMOUNT = 100;
    private static final int WEEKDAY_AND_WEEKEND_DISCOUNT_AMOUNT_PER_MENU = 2023;
    private static final int SPECIAL_DAY_DISCOUNT_AMOUNT = 1000;

    private final Map<BenefitType, Integer> benefits;
    private final Calendar calendar;

    public Benefit(Map<BenefitType, Integer> benefits, Calendar calendar) {
        this.benefits = benefits;
        this.calendar = calendar;
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
        int calculation = calendar.CalculationForDDayDiscountAmount();
        if (calculation != NOTHING) {
            benefits.put(
                    BenefitType.CHRISTMAS_D_DAY,
                    D_DAY_DISCOUNT_BASIC_AMOUNT + (calculation * D_DAY_DISCOUNT_INCREMENT_AMOUNT)
            );
        }
    }

    public void calculateWeekDayOrWeekendDiscountAmount(Map<String, Integer> menuType) {
        if (calendar.judgeIsWeekdayOrWeekend().equals("weekday")) {
            benefits.put(BenefitType.WEEKDAY, menuType.get("디저트") * WEEKDAY_AND_WEEKEND_DISCOUNT_AMOUNT_PER_MENU);
        }
        if (calendar.judgeIsWeekdayOrWeekend().equals("weekend")) {
            benefits.put(BenefitType.WEEKEND, menuType.get("메인") * WEEKDAY_AND_WEEKEND_DISCOUNT_AMOUNT_PER_MENU);
        }
    }

    public void calculateSpecialDayDiscountAmount() {
        if (calendar.judgeIsSpecialDay().equals("specialDay")) {
            benefits.put(BenefitType.SPECIAL, SPECIAL_DAY_DISCOUNT_AMOUNT);
        }
    }
}
