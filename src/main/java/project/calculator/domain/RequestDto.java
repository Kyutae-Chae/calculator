package project.calculator.domain;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Data
public class RequestDto {

    @NotNull
    private Operator operator;
    @NotNull
    private BigDecimal operand1;
    @NotNull
    private BigDecimal operand2;

}
