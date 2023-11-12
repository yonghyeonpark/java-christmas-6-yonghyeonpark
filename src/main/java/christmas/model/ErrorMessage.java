package christmas.model;

public enum ErrorMessage {

    DATE("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요."),
    ORDER("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");

    private String content;

    ErrorMessage(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }
}
