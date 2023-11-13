package christmas.service;

public class ChristmasService {

    public boolean isEventApplication(int totalOrderAmount) {
        if (totalOrderAmount >= 10000) {
            return true;
        }
        return false;
    }

    public String getGiftMenu(int totalOrderAmount) {
        if (totalOrderAmount >= 120000) {
            return "샴페인 1개";
        }
        return "없음";
    }

    public int calculatePaymentAmount(int totalOrderAmount, int totalDiscountAmount) {
        return totalOrderAmount - totalDiscountAmount;
    }

    public String judgeEventBadge(int totalBenefitAmount) {
        if (isStarBadge(totalBenefitAmount)) {
            return "별";
        }
        if (isTreeBadge(totalBenefitAmount)) {
            return "트리";
        }
        if (isSantaBadge(totalBenefitAmount)) {
            return "산타";
        }
        return "없음";
    }

    private boolean isStarBadge(int totalBenefitAmount) {
        return (totalBenefitAmount >= 5000) && (totalBenefitAmount < 10000);
    }

    private boolean isTreeBadge(int totalBenefitAmount) {
        return (totalBenefitAmount >= 10000) && (totalBenefitAmount < 20000);
    }

    private boolean isSantaBadge(int totalBenefitAmount) {
        return totalBenefitAmount >= 20000;
    }
}
