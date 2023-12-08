package christmas.domain;

public class Event {

    private static final int EVENT_APPLICATION_CRITERIA = 10000;
    private static final int GIFT_APPLICATION_CRITERIA = 120000;
    private static final String NOTHING = "없음";
    private static final String GIFT = "샴페인 1개";

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

    public String getGift() {
        if (order.calculateTotalAmount() > GIFT_APPLICATION_CRITERIA) {
            return GIFT;
        }
        return NOTHING;
    }

    public int calculatePaymentAmount() {
        return order.calculateTotalAmount() - benefit.calculateTotalAmount();
    }
}
