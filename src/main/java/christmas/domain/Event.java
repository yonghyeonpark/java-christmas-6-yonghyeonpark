package christmas.domain;

public class Event {

    private static final int EVENT_APPLICATION_CRITERIA = 10000;

    private final Order order;
    private final Discount discount;

    public Event(Order order, Discount discount) {
        this.order = order;
        this.discount = discount;
    }

    public boolean isApply() {
        if (order.calculateTotalAmount() > EVENT_APPLICATION_CRITERIA) {
            return true;
        }
        return false;
    }
}
