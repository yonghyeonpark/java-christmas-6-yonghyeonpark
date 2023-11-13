package christmas.model;

public enum BenefitType {
    CHRISTMAS_D_DAY("크리스마스 디데이 할인"),
    WEEKDAY("평일 할인"),
    WEEKEND("주말 할인"),
    SPECIAL("특별 할인"),
    GIFT_EVENT("증정 이벤트");

    private String name;

    BenefitType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
