package project.calculator.domain;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter @Setter
public class FormDto {
    private Operator operator;
    private BigDecimal operand1;
    private BigDecimal operand2;
    private BigDecimal result;
}
