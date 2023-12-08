package christmas.domain;

import christmas.util.Convert;

public class Date {

    private static final int DECEMBER_FIRST_DATE = 1;
    private static final int DECEMBER_LAST_DATE = 31;
    private static final int CHRISTMAS = 25;
    private static final String DATE_ERROR_MESSAGE = "[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.";

    private final int date;

    public Date(String inputDate) {
        int date = validateFormat(inputDate);
        validateRange(date);
        this.date = date;
    }

    public int getDate() {
        return date;
    }

    private int validateFormat(String inputDate) {
        return Convert.stringToInt(inputDate, DATE_ERROR_MESSAGE);
    }

    private void validateRange(int date) {
        if (date > DECEMBER_LAST_DATE || date < DECEMBER_FIRST_DATE) {
            throw new IllegalArgumentException(DATE_ERROR_MESSAGE);
        }
    }

    public boolean isOverChristmas() {
        if (date > CHRISTMAS) {
            return true;
        }
        return false;
    }

    public boolean isSpecialDay() {
        for (int specialDay : Day.SPECIAL.getDay()) {
            if (date == specialDay) {
                return true;
            }
        }
        return false;
    }

    public boolean isWeekEnd() {
        for (int weekEnd : Day.WEEKEND.getDay()) {
            if (date == weekEnd) {
                return true;
            }
        }
        return false;
    }
}
