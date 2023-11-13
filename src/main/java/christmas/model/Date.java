package christmas.model;

import christmas.util.Convert;
import java.util.List;

public class Date {

    private static final int FIRST_DAY_OF_DECEMBER = 1;
    private static final int LAST_DAY_OF_DECEMBER = 31;
    private static final int CHRISTMAS_DAY = 25;
    private static final int ONE = 1;
    private static final int NOTHING = -1;
    private static final String DATE_INPUT_ERROR_MESSAGE = ErrorMessage.DATE.getContent();
    private static final List<Integer> weekend = List.of(1, 2, 8, 9, 15, 16, 22, 23, 29, 30);
    private static final List<Integer> specialDay = List.of(3, 10, 17, 24, 25, 31);

    private final int date;

    public Date(String inputDate) {
        int date = Convert.stringToInteger(inputDate, DATE_INPUT_ERROR_MESSAGE);
        validateRange(date);
        this.date = date;
    }

    private void validateRange(int date) {
        if (date < FIRST_DAY_OF_DECEMBER || date > LAST_DAY_OF_DECEMBER) {
            throw new IllegalArgumentException(DATE_INPUT_ERROR_MESSAGE);
        }
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

    public int CalculationForDDayDiscountAmount() {
        if (date <= CHRISTMAS_DAY) {
            return date - ONE;
        }
        return NOTHING;
    }
}
