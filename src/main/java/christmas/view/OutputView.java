package christmas.view;

public class OutputView {

    private static final String START_MESSAGE = "안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.";
    private static final String EVENT_BENEFIT_PREVIEW_MESSAGE = "12월 %d일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!";
    private static final String NEW_LINE = "\n";

    public void printStartMessage() {
        System.out.println(START_MESSAGE);
    }

    public void printEventBenefitPreviewMessage(int date) {
        System.out.printf(EVENT_BENEFIT_PREVIEW_MESSAGE, date);
        System.out.println(NEW_LINE);
    }
}
