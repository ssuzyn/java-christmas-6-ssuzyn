package christmas.constant;

public enum ErrorCode {

    PREFIX("[ERROR] "),
    NOT_INTEGER("입력한 값이 숫자가 아닙니다. 다시 입력해 주세요."),
    DATE_IS_NOT_IN_DECENBER("유효하지 않은 날짜입니다. 다시 입력해 주세요.");

    private final String message;

    ErrorCode(String message) {
        this.message = message;
    }

    public String getMessage(){
        return PREFIX.message + this.message;
    }
}
