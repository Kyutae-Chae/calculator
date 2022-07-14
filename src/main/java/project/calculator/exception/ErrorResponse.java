package project.calculator.exception;

import lombok.Getter;

import java.net.ConnectException;

@Getter
public class ErrorResponse {
    private String message;

    private ErrorResponse(String message) {
        this.message = message;
    }

    public static ErrorResponse of(ArithmeticException e) {
        return new ErrorResponse("계산이 불가능한 식입니다!! (ArithmeticException)");
    }

    public static ErrorResponse of(ConnectException e) {
        return new ErrorResponse("데이터 베이스 연결이 원활하지 않습니다.");
    }

    public static ErrorResponse of(HistoryException e) {
        return new ErrorResponse(e.getMessage());
    }
}
