package project.calculator.advice;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import project.calculator.exception.ErrorResponse;
import project.calculator.exception.HistoryException;


@RestControllerAdvice
public class GlobalExceptionAdvice {
    @ExceptionHandler
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorResponse handleException(ArithmeticException e) {
        final ErrorResponse response = ErrorResponse.of(e);
        e.printStackTrace();
        return response;
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorResponse handleException(HistoryException e) {
        final ErrorResponse response = ErrorResponse.of(e);
        e.printStackTrace();
        return response;
    }

}
