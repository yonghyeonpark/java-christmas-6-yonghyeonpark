package christmas.view;

import christmas.util.Convert;

public class OutputView {

    private static final String START_MESSAGE = "안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.";
    private static final String EVENT_BENEFIT_PREVIEW_MESSAGE = "12월 %s일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!";
    private static final String ORDER_MENU_MESSAGE = "<주문 메뉴>";
    private static final String GIFT_MENU_MESSAGE = "<증정 메뉴>";
    private static final String BENEFITS_MESSAGE = "<혜택 내역>";
    private static final String TOTAL_ORDER_AMOUNT_MESSAGE = "<할인 전 총주문 금액>";
    private static final String TOTAL_BENEFIT_AMOUNT_MESSAGE = "<총혜택 금액>";
    private static final String TOTAL_PAYMENT_AMOUNT_MESSAGE = "<할인 후 예상 결제 금액>";
    private static final String DECEMBER_EVENT_BADGE_MESSAGE = "<12월 이벤트 배지>";
    private static final String NEW_LINE = "\n";
    private static final String MINUS = "-";

    public void printStartMessage() {
        System.out.println(START_MESSAGE);
    }

    public void printEventBenefitPreviewMessage(String inputDate) {
        System.out.printf(EVENT_BENEFIT_PREVIEW_MESSAGE, inputDate);
        System.out.println(NEW_LINE);
    }

    public void printOrderMenu(String orderMenu) {
        System.out.println(ORDER_MENU_MESSAGE);
        System.out.println(orderMenu);
    }

    public void printTotalOrderAmount(int totalOrderAmount) {
        System.out.println(TOTAL_ORDER_AMOUNT_MESSAGE);
        System.out.println(Convert.formatIntegerToString(totalOrderAmount));
        System.out.println();
    }

    public void printGiftMenu(String giftMenu) {
        System.out.println(GIFT_MENU_MESSAGE);
        System.out.println(giftMenu);
        System.out.println();
    }

    public void printBenefits(String benefits) {
        System.out.println(BENEFITS_MESSAGE);
        System.out.println(benefits);
    }

    public void printTotalBenefitAmount(int totalBenefitAmount) {
        System.out.println(TOTAL_BENEFIT_AMOUNT_MESSAGE);
        System.out.println(MINUS + Convert.formatIntegerToString(totalBenefitAmount));
        System.out.println();
    }

    public void printTotalPaymentAmount(int totalPaymentAmount) {
        System.out.println(TOTAL_PAYMENT_AMOUNT_MESSAGE);
        System.out.println(Convert.formatIntegerToString(totalPaymentAmount));
        System.out.println();
    }

    public void printEventBadge(String eventBadge) {
        System.out.println(DECEMBER_EVENT_BADGE_MESSAGE);
        System.out.print(eventBadge);
    }
}
