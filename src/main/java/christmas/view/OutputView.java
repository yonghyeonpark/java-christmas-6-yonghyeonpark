package christmas.view;

public class OutputView {

    private static final String EVENT_PLANNER_START_MESSAGE = "안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.";
    private static final String EVENT_BENEFIT_GUIDE_MESSAGE = "12월 %d일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!";
    private static final String ORDERS_FORMAT = "<주문 메뉴>";
    private static final String ORDER_AMOUNT_FORMAT = "<할인 전 총주문 금액>";
    private static final String GIFT_FORMAT = "<증정 메뉴>";
    private static final String BENEFITS_FORMAT = "<혜택 내역>";
    private static final String BENEFIT_AMOUNT_FORMAT = "<총혜택 금액>";
    private static final String PAYMENT_AMOUNT_FORMAT = "<할인 후 예상 결제 금액>";
    private static final String BADGE_FORMAT = "<12월 이벤트 배지>";

    public void printEventPlannerStartMessage() {
        System.out.println(EVENT_PLANNER_START_MESSAGE);
    }

    public void printEventBenefitGuideMessage(int date) {
        System.out.println(String.format(EVENT_BENEFIT_GUIDE_MESSAGE, date));
        System.out.println();
    }

    public void printOrders(String orders) {
        System.out.println(ORDERS_FORMAT);
        System.out.println(orders);
        System.out.println();
    }

    public void printOrderAmount(String orderAmount) {
        System.out.println(ORDER_AMOUNT_FORMAT);
        System.out.println(orderAmount);
        System.out.println();
    }

    public void printGift(String gift) {
        System.out.println(GIFT_FORMAT);
        System.out.println(gift);
        System.out.println();
    }

    public void printBenefits(String benefits) {
        System.out.println(BENEFITS_FORMAT);
        System.out.println(benefits);
        System.out.println();
    }

    public void printBenefitAmount(String benefitAmount) {
        System.out.println(BENEFIT_AMOUNT_FORMAT);
        System.out.println(benefitAmount);
        System.out.println();
    }

    public void printPaymentAmount(String paymentAmount) {
        System.out.println(PAYMENT_AMOUNT_FORMAT);
        System.out.println(paymentAmount);
        System.out.println();
    }

    public void printBadge(String badge) {
        System.out.println(BADGE_FORMAT);
        System.out.println(badge);
    }
}
