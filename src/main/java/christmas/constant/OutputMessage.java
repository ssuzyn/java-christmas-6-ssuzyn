package christmas.constant;

public enum OutputMessage {

    RESERVATION_DATE("12월 %d일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!"),
    ORDER_MENU_PREFIX("<주문 메뉴>%n%s"),
    ORDER_MENU("%s %d개\n"),
    BEFORE_DISCOUNT_AMOUNT("<할인 전 총주문 금액>%n%,d원\n"),
    GIVEAWAY_MENU("<증정 메뉴>%n%s"),
    DOES_NOT_EXIST("없음\n"),
    CHAMPAGNE("샴페인 1개\n"),
    BENEFIT_DETAILS_PREFIX("<혜택 내역>%n%s"),
    BENEFIT_DETAILS("%s: %,d원\n"),
    TOTAL_BENEFIT_AMOUNT("<총혜택 금액>%n%,d원\n"),
    AFTER_DISCOUNT_AMOUNT("<할인 후 예상 결제 금액>%n%,d원\n"),
    PROMOTION_BADGE("<12월 이벤트 배지>%n%s\n");

    private final String message;

    OutputMessage(String message) {
        this.message = message;
    }

    public String getMessage(){
        return this.message;
    }
}
