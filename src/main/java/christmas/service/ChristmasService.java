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
}
