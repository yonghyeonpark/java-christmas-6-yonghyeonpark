package christmas.domain;

public class Discount {

    private static final int D_DAY_DISCOUNT_BASIC_AMOUNT = 1000;
    private static final int D_DAY_DISCOUNT_ADDITIONAL_AMOUNT = 100;

    private final Date date;
    private final Order order;

    public Discount(Date date, Order order) {
        this.date = date;
        this.order = order;
    }

    public int calculateDDayDiscount() {
        if (date.isOverChristmas()) {
            return 0;
        }
        return D_DAY_DISCOUNT_BASIC_AMOUNT + ((date.getDate() - 1) * D_DAY_DISCOUNT_ADDITIONAL_AMOUNT);
    }
}
