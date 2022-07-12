package project.calculator.service;

import project.calculator.domain.RequestDto;

import java.math.BigDecimal;

public interface CalculatorService {
    public BigDecimal calculate(RequestDto request);
}
