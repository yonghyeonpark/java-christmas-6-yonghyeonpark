package christmas.view;

import camp.nextstep.edu.missionutils.Console;
import christmas.util.Convert;

public class InputView {

    private static final String VISIT_DATE_INPUT_MESSAGE = "12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)";

    public int readDate() {
        System.out.println(VISIT_DATE_INPUT_MESSAGE);
        String input = Console.readLine();
        return Convert.StringToInteger(input);
    }
}
