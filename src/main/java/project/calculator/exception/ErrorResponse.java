package project.calculator.exception;

import lombok.Getter;

@Getter
public class ErrorResponse {
    private String message;

    private ErrorResponse(String message) {
        this.message = message;
    }

    public static ErrorResponse of(ArithmeticException e) {
        return new ErrorResponse("계산이 불가능한 식입니다!! (ArithmeticException)");
    }

    public static ErrorResponse of(HistoryException e) {
        return new ErrorResponse(e.getMessage());
    }
}
