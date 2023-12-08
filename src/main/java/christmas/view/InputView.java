package christmas.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {

    private static final String DATE_INPUT_MESSAGE = "12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)";
    private static final String ORDER_INPUT_MESSAGE = "주문하실 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)";

    public String readDate() {
        System.out.println(DATE_INPUT_MESSAGE);
        return readLine();
    }

    public String readOrder() {
        System.out.println(ORDER_INPUT_MESSAGE);
        return readLine();
    }
}
