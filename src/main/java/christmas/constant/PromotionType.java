package christmas.constant;

public enum PromotionType {

    DDAY("크리스마스 디데이 할인"),
    GIFT("증정 이벤트"),
    SPECIAL("특별 할인"),
    WEEKDAY("평일 할인"),
    WEEKEND("주말 할인");

    private final String message;

    PromotionType(String message) {
        this.message = message;
    }

    public String getMessage(){
        return this.message;
    }
}
