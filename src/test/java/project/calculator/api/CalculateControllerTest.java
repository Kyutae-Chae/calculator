package project.calculator.api;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import project.calculator.domain.Operator;
import project.calculator.domain.RequestDto;
import project.calculator.service.CalculatorServiceImpl;

import java.math.BigDecimal;

@SpringBootTest
@Transactional
class CalculateControllerTest {

    @Autowired
    private CalculatorServiceImpl calculatorService;


    @Test
    public void caltulate() throws Exception {
        RequestDto requestDto = new RequestDto();
        requestDto.setOperand1(BigDecimal.valueOf(12));
        requestDto.setOperand2(BigDecimal.valueOf(22));
        requestDto.setOperator(Operator.PLUS);

        BigDecimal calculate = calculatorService.calculate(requestDto);

        Assertions.assertThat(calculate.longValue()).isEqualTo(12+22);

        requestDto.setOperator(Operator.MINUS);
        calculate = calculatorService.calculate(requestDto);
        Assertions.assertThat(calculate.longValue()).isEqualTo(12-22);

        requestDto.setOperator(Operator.DIVISION);
        calculate = calculatorService.calculate(requestDto);
        Assertions.assertThat(calculate.longValue()).isEqualTo(12/22);

        requestDto.setOperator(Operator.MULTI);
        calculate = calculatorService.calculate(requestDto);
        Assertions.assertThat(calculate.longValue()).isEqualTo(12*22);
    }

}