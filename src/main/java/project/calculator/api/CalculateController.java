package project.calculator.api;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import project.calculator.domain.RequestDto;
import project.calculator.domain.ResponseDto;
import project.calculator.service.CalculatorService;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/calculate")
@RequiredArgsConstructor
public class CalculateController {

    private final CalculatorService calculatorService;

    @PostMapping
    public ResponseEntity calculate(@RequestBody @Valid RequestDto requestDto) {
        ResponseDto response = new ResponseDto();
        response.setRequest(requestDto);
        response.setResult(calculatorService.calculate(requestDto));
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

}
