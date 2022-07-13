package project.calculator.exception;

public class HistoryException extends RuntimeException {
    private ExceptionCode exceptionCode;

    public HistoryException(ExceptionCode exceptionCode) {
        super(exceptionCode.getMessage());
        this.exceptionCode = exceptionCode;
    }
}
