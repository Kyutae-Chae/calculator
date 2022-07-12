package project.calculator.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import project.calculator.domain.HistoryEntity;
import project.calculator.domain.RequestDto;
import project.calculator.repository.HistoryRepository;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

@Service
@RequiredArgsConstructor
public class CalculatorServiceImpl implements CalculatorService {

    private final HistoryRepository historyRepository;

    @Override
    public BigDecimal calculate(RequestDto request) {

        BigDecimal result = BigDecimal.ZERO;
        BigDecimal first = request.getOperand1();
        BigDecimal second = request.getOperand2();

        switch (request.getOperator().getType()) {
            case "+":
                result = first.add(second);
                break;
            case "-":
                result = first.subtract(second);
                break;
            case "*":
                result = first.multiply(second);
                break;
            case "/":
                //0으로 나눌때 예외처리
                result = first.divide(second, new MathContext(34, RoundingMode.DOWN));
                //result = first.divide(second, MathContext.DECIMAL128);
                break;
            default:
                result = BigDecimal.ZERO;
                break;
        }

        HistoryEntity history = new HistoryEntity();
        history.setOperand1(first);
        history.setOperand2(second);
        history.setOperator(request.getOperator());
        history.setResult(result);
        historyRepository.save(history);
        return result;
    }
}
