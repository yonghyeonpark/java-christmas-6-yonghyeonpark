package christmas.service;

import christmas.model.Benefit;
import christmas.model.Date;
import christmas.model.Event;
import christmas.model.Menu;
import christmas.model.Order;
import java.util.HashMap;

public class ChristmasService {

    private final Date date;
    private final Menu menu;
    private final Order order;
    private final Benefit benefit;
    private final Event event;

    public ChristmasService(Date date, Menu menu, Order order) {
        this.date = date;
        this.menu = menu;
        this.order = order;
        this.benefit = new Benefit(new HashMap<>(), date);
        this.event = new Event();
        setUp();
    }

    private void setUp() {
        benefit.calculateDDayDiscountAmount();
        benefit.calculateWeekDayOrWeekendDiscountAmount(menu.getMenuType());
        benefit.calculateSpecialDayDiscountAmount();
        benefit.calculateGiftEventDiscountAmount(getGiftMenu());
    }

    public String getOrders() {
        return order.toString();
    }

    public String getBenefits() {
        return benefit.toString();
    }

    public int getDate() {
        return date.getDate();
    }

    public String getGiftMenu() {
        return event.getGiftMenu(getTotalOrderAmount());
    }

    public int getTotalBenefitAmount() {
        return benefit.calculateTotalBenefitAmount();
    }

    public int getPaymentAmount() {
        return event.calculatePaymentAmount(getTotalOrderAmount(), getTotalDiscountAmount());
    }

    public int getTotalOrderAmount() {
        return order.calculateTotalOrderAmount();
    }

    public int getTotalDiscountAmount() {
        return benefit.calculateTotalDiscountAmount();
    }

    public String getEventBadge() {
        return event.judgeEventBadge(getTotalBenefitAmount());
    }
}
