package christmas.constant;

public enum OutputMessage {

    RESERVATION_DATE("12월 %d일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!"),
    ORDER_MENU_PREFIX("<주문 메뉴>"),
    ORDER_MENU("%s %d개"),
    BEFORE_DISCOUNT_AMOUNT("<할인 전 총주문 금액>\n%,d원");

    private final String message;

    OutputMessage(String message) {
        this.message = message;
    }

    public String getMessage(){
        return this.message;
    }
}
