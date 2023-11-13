package christmas.model;

import java.util.Map;

public class Benefit {

    private static final int INITIAL_AMOUNT = 0;
    private static final int CHRISTMAS_DAY = 25;
    private static final int D_DAY_DISCOUNT_BASIC_AMOUNT = 1000;
    private static final int D_DAY_DISCOUNT_INCREMENT_AMOUNT = 100;
    private static final int ONE = 1;

    private final Map<BenefitType, Integer> benefits;

    public Benefit(Map<BenefitType, Integer> benefits) {
        this.benefits = benefits;
        setUp();
    }

    private void setUp() {
        benefits.put(BenefitType.CHRISTMAS_D_DAY, INITIAL_AMOUNT);
        benefits.put(BenefitType.WEEKDAY, INITIAL_AMOUNT);
        benefits.put(BenefitType.WEEKEND, INITIAL_AMOUNT);
        benefits.put(BenefitType.SPECIAL, INITIAL_AMOUNT);
        benefits.put(BenefitType.GIFT_EVENT, INITIAL_AMOUNT);
    }

    public void calculateDDayDiscount(int date) {
        if (date <= CHRISTMAS_DAY) {
            benefits.put(
                    BenefitType.CHRISTMAS_D_DAY,
                    D_DAY_DISCOUNT_BASIC_AMOUNT + ((date - ONE) * D_DAY_DISCOUNT_INCREMENT_AMOUNT)
            );
        }
    }
}
