package christmas.domain;

public class Event {

    private static final int EVENT_APPLICATION_CRITERIA = 10000;

    private final Order order;
    private final Benefit benefit;

    public Event(Order order, Benefit benefit) {
        this.order = order;
        this.benefit = benefit;
    }

    public boolean isApply() {
        if (order.calculateTotalAmount() > EVENT_APPLICATION_CRITERIA) {
            return true;
        }
        return false;
    }
}
