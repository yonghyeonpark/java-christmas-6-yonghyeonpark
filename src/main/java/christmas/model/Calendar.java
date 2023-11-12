package christmas.model;

import christmas.util.Convert;
import java.util.List;

public class Calendar {

    private static final String DATE_INPUT_ERROR_MESSAGE = ErrorMessage.DATE.getContent();

    private final int date;
    private List<Integer> weekend;
    private List<Integer> specialDay;

    public Calendar(String inputDate) {
        int date = Convert.stringToInteger(inputDate, DATE_INPUT_ERROR_MESSAGE);
        validateRange(date);
        this.date = date;
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

    public int calculateBeforeDDayDiscount() {
        if (date <= 25) {
            return date - 1;
        }
        return -1;
    }
}
