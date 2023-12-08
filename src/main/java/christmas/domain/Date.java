package christmas.domain;

public class Date {

    private static final String DATE_ERROR_MESSAGE = "[ERROR] 유효하지 않은 날짜입니다.";

    private final int date;

    public Date(String inputDate) {
        int date = validateFormat(inputDate);
        validateRange(date);
        this.date = date;
    }

    private int validateFormat(String inputDate) {
        try {
            return Integer.parseInt(inputDate);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(DATE_ERROR_MESSAGE);
        }
    }

    private void validateRange(int date) {
        if (date > 31 || date < 1) {
            throw new IllegalArgumentException(DATE_ERROR_MESSAGE);
        }
    }

    public boolean isOverChristmas() {
        if (date > 25) {
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
