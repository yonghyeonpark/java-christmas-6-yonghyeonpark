package christmas.model;

import java.util.List;

public class Calendar {

    private static final String DATE_INPUT_ERROR_MESSAGE = "[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.";

    private final int date;
    private List<Integer> weekend;
    private List<Integer> specialDay;

    public Calendar(int date) {
        this.date = date;
        validateRange(date);
        initialize();
    }

    private void validateRange(int date) {
        if (date < 1 || date > 31) {
            throw new IllegalArgumentException(DATE_INPUT_ERROR_MESSAGE);
        }
    }

    private void initialize() {
        weekend = List.of(1, 2, 8, 9, 15, 16, 22, 23, 29, 30);
        specialDay = List.of(3, 10, 17, 24, 25, 31);
    }

    public String judgeIsWeekdayOrWeekend() {
        if (weekend.contains(date)) {
            return "weekend";
        }
        return "weekday";
    }

    public String judgeIsSpecialDay() {
        if (specialDay.contains(date)) {
            return "specialDay";
        }
        return "nothing";
    }

    public int calculateChristmasDDay() {
        if (date <= 25) {
            return (25 - date);
        }
        return -1;
    }
}
