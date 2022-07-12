package project.calculator.domain;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;


@Data
public class HistoryDto {
    private Long id;
    private BigDecimal result;
    private Operator operator;
    private BigDecimal operand1;
    private BigDecimal operand2;
    private LocalDateTime localDateTime;
}
