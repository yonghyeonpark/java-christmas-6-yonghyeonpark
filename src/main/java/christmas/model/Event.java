package christmas.model;

public class Event {

    private static final int MIN_AMOUNT_FOR_EVENT_APPLICATION = 10000;
    private static final int MIN_AMOUNT_FOR_GIFT_MENU = 120000;
    private static final int MIN_AMOUNT_FOR_STAR_BADGE = 5000;
    private static final int MIN_AMOUNT_FOR_TREE_BADGE = 10000;
    private static final int MIN_AMOUNT_FOR_SANTA_BADGE = 20000;
    private static final String NOTHING = "없음";

    public boolean isEventApplication(int totalOrderAmount) {
        if (totalOrderAmount >= MIN_AMOUNT_FOR_EVENT_APPLICATION) {
            return true;
        }
        return false;
    }

    public String getGiftMenu(int totalOrderAmount) {
        if (totalOrderAmount >= MIN_AMOUNT_FOR_GIFT_MENU) {
            return EventGift.ONE_CHAMPAGNE.getName();
        }
        return NOTHING;
    }

    public int calculatePaymentAmount(int totalOrderAmount, int totalDiscountAmount) {
        return totalOrderAmount - totalDiscountAmount;
    }

    public String judgeEventBadge(int totalBenefitAmount) {
        if (isStarBadge(totalBenefitAmount)) {
            return EventGift.STAR_BADGE.getName();
        }
        if (isTreeBadge(totalBenefitAmount)) {
            return EventGift.TREE_BADGE.getName();
        }
        if (isSantaBadge(totalBenefitAmount)) {
            return EventGift.SANTA_BADGE.getName();
        }
        return NOTHING;
    }

    private boolean isStarBadge(int totalBenefitAmount) {
        return (totalBenefitAmount >= MIN_AMOUNT_FOR_STAR_BADGE) && (totalBenefitAmount < MIN_AMOUNT_FOR_TREE_BADGE);
    }

    private boolean isTreeBadge(int totalBenefitAmount) {
        return (totalBenefitAmount >= MIN_AMOUNT_FOR_TREE_BADGE) && (totalBenefitAmount < MIN_AMOUNT_FOR_SANTA_BADGE);
    }

    private boolean isSantaBadge(int totalBenefitAmount) {
        return totalBenefitAmount >= MIN_AMOUNT_FOR_SANTA_BADGE;
    }
}
