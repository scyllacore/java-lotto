package lotto.exception;

public enum IllegalArgument {
    WRONG_INPUT("잘못된 형태의 입력입니다."),
    //WRONG_DIVISION_DATA("잘못된 형태의 통계 데이터입니다."),
    WRONG_NUMBER("처리할 수 없는 숫자가 존재합니다."),
    WRONG_AMOUNT_PAID("처리할 수 없는 금액입니다.");

    private String error = "[ERROR] ";
    private String message;

    IllegalArgument(String message) {
        this.message = error + message;
    }

    public String getMessage() {
        return message;
    }

    public static void handleException(String message) {
        throw new IllegalArgumentException(message);
    }
}
