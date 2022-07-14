package project.calculator.advice;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import project.calculator.exception.ErrorResponse;
import project.calculator.exception.HistoryException;
import project.calculator.service.LogService;

import java.net.ConnectException;
import java.nio.channels.ConnectionPendingException;


@RestControllerAdvice
@RequiredArgsConstructor
public class GlobalExceptionAdvice {
    private final LogService log;

    @ExceptionHandler
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorResponse handleException(ArithmeticException e) {
        final ErrorResponse response = ErrorResponse.of(e);
        log.error(e.getMessage());
        return response;
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorResponse handleException(HistoryException e) {
        final ErrorResponse response = ErrorResponse.of(e);
        log.error(e.getMessage());
        return response;
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorResponse handleException(ConnectException e) {
        final ErrorResponse response = ErrorResponse.of(e);
        log.error(e.getMessage());
        return response;
    }
}
