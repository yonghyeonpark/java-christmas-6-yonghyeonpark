package christmas.model;

import java.util.List;

public class Calendar {

    private final int date;
    private List<Integer> weekend;
    private List<Integer> specialDay;

    public Calendar(int date) {
        this.date = date;
        initialize();
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
}
