package christmas.controller;

import christmas.domain.Benefit;
import christmas.domain.Date;
import christmas.domain.Event;
import christmas.domain.Order;
import christmas.view.InputView;
import christmas.view.OutputView;

public class Controller {

    private static final String NON_BENEFIT_AMOUNT = "0원";
    private static final String NOTHING = "없음";

    private final InputView inputView;
    private final OutputView outputView;
    private Event event;

    public Controller(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        outputView.printEventPlannerStartMessage();
        setUp();
        outputView.printEventBenefitGuideMessage(event.getDate());
        outputView.printOrders(event.getOrders());
        outputView.printOrderAmount(event.getOrderAmount());
        applyEvent();
        noApplyEvent();
    }

    private void setUp() {
        Date date = getDate();
        Order order = getOrder();
        Benefit benefit = new Benefit(date, order);
        event = new Event(order, benefit, date);
    }

    private Date getDate() {
        while (true) {
            try {
                String inputDate = inputView.readDate();
                Date date = new Date(inputDate);
                return date;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private Order getOrder() {
        while (true) {
            try {
                String inputOrder = inputView.readOrder();
                Order order = new Order(inputOrder);
                return order;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void applyEvent() {
        if (event.isApply()) {
            outputView.printGift(event.getGift());
            outputView.printBenefits(event.getBenefits());
            outputView.printBenefitAmount(event.getBenefitAmount());
            outputView.printPaymentAmount(event.getPaymentAmount());
            outputView.printBadge(event.getBadge());
        }
    }

    private void noApplyEvent() {
        if (!event.isApply()) {
            outputView.printGift(NOTHING);
            outputView.printBenefits(NOTHING);
            outputView.printBenefitAmount(NON_BENEFIT_AMOUNT);
            outputView.printPaymentAmount(event.getOrderAmount());
            outputView.printBadge(NOTHING);
        }
    }
}
