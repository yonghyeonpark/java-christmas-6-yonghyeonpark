package christmas.domain;

public class Event {

    private static final int EVENT_APPLICATION_CRITERIA = 10000;
    private static final String NOTHING = "없음";

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

    public String getBadge() {
        int totalBenefitAmount = benefit.calculateTotalAmount();
        if (totalBenefitAmount >= Badge.STAR.getStandard() && totalBenefitAmount < Badge.TREE.getStandard()) {
            return Badge.STAR.getName();
        }
        if (totalBenefitAmount >= Badge.TREE.getStandard() && totalBenefitAmount < Badge.SANTA.getStandard()) {
            return Badge.TREE.getName();
        }
        if (totalBenefitAmount >= Badge.SANTA.getStandard()) {
            return Badge.SANTA.getName();
        }
        return NOTHING;
    }
}
