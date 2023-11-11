package christmas.constant;

public enum InputMessage {

    WELCOME_STATEMENT("안녕하세요! 우테코 식당 12월 이벤트 플래너입니다."),
    VISIT_DATE("12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)");

    private final String message;

    InputMessage(String message) {
        this.message = message;
    }

    public String getMessage(){
        return this.message;
    }
}
