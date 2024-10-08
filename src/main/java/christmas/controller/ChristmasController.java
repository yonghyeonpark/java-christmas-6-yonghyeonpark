package christmas.controller;

import christmas.model.Date;
import christmas.model.Menu;
import christmas.model.Order;
import christmas.service.ChristmasService;
import christmas.view.InputView;
import christmas.view.OutputView;
import java.util.HashMap;
import java.util.List;

public class ChristmasController {

    private static final int ZERO = 0;
    private static final String NOTHING = "없음";

    private final InputView inputView;
    private final OutputView outputView;
    private ChristmasService christmasService;

    public ChristmasController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void createEventPlanner() {
        printStartMessage();
        setUp();
        eventBenefitPreview();
    }

    private void printStartMessage() {
        outputView.printStartMessage();
    }

    private void setUp() {
        Date date = getDate();
        Menu menu = new Menu(new HashMap<>());
        Order order = getOrder(menu);
        christmasService = new ChristmasService(date, menu, order);
    }

    private Date getDate() {
        while (true) {
            try {
                String inputDate = inputView.readDate();
                return new Date(inputDate);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private Order getOrder(Menu menu) {
        while (true) {
            try {
                List<String> unorganizedOrders = inputView.readOrder();
                return new Order(unorganizedOrders, menu);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void eventBenefitPreview() {
        if (christmasService.isEventApplication()) {
            applyEvent();
        }
        if (!christmasService.isEventApplication()) {
            notApplyEvent();
        }
    }

    private void applyEvent() {
        outputView.printEventBenefitPreviewMessage(christmasService.getDate());
        outputView.printOrderMenu(christmasService.getOrders());
        outputView.printTotalOrderAmount(christmasService.getTotalOrderAmount());
        outputView.printGiftMenu(christmasService.getGiftMenu());
        outputView.printBenefits(christmasService.getBenefits());
        outputView.printTotalBenefitAmount(christmasService.getTotalBenefitAmount());
        outputView.printPaymentAmount(christmasService.getPaymentAmount());
        outputView.printEventBadge(christmasService.getEventBadge());
    }

    private void notApplyEvent() {
        outputView.printEventBenefitPreviewMessage(christmasService.getDate());
        outputView.printOrderMenu(christmasService.getOrders());
        outputView.printTotalOrderAmount(christmasService.getTotalOrderAmount());
        outputView.printGiftMenu(NOTHING);
        outputView.printBenefits(NOTHING);
        outputView.printTotalBenefitAmount(ZERO);
        outputView.printPaymentAmount(christmasService.getTotalOrderAmount());
        outputView.printEventBadge(NOTHING);
    }
}
