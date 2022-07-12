package project.calculator.domain;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ResponseDto {

    private RequestDto request;
    private BigDecimal result;

    public double getResult() {
        return result.doubleValue();
    }
}
