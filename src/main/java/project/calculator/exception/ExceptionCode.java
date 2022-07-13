package project.calculator.exception;

import lombok.Getter;

public enum ExceptionCode {
    HISTORY_NOT_FOUND(999, "해당 계산 history를 찾을 수 없습니다."),
    METHOD_NOT_ALLOWED(405, "Method Not Allowed"),
    INTERNAL_SERVER_ERROR(500, "Internal Server Error");

    @Getter
    private int status;

    @Getter
    private String message;

    ExceptionCode(int code, String message) {
        this.status = code;
        this.message = message;
    }
}
