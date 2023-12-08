package christmas.domain;

import java.util.List;

public enum Day {

    WEEKEND(List.of(1, 2, 8, 9, 15, 16, 22, 23, 29, 30)),
    SPECIAL(List.of(3, 10, 17, 24, 25, 31));

    private List<Integer> day;

    Day(List<Integer> day) {
        this.day = day;
    }

    public List<Integer> getDay() {
        return day;
    }
}
