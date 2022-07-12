package project.calculator.domain;

import lombok.Data;

import java.math.BigDecimal;


@Data
public class HistoryDto {
    private Long id;
    private BigDecimal result;
    private Operator operator;
    private BigDecimal operand1;
    private BigDecimal operand2;
}
