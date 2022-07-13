package project.calculator.api;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
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

    @ApiOperation(value = "계산하기", notes = "RequestDto를 JSON으로 전달받아 결과값을 리턴")
    @ApiResponses({
            @ApiResponse(code = 201, message = "결과 정상 리턴"),
            @ApiResponse(code = 400, message = "잘못된 request")
    })
    @PostMapping
    public ResponseEntity calculate(@RequestBody @Valid RequestDto requestDto) {
        ResponseDto response = new ResponseDto();
        response.setRequest(requestDto);
        response.setResult(calculatorService.calculate(requestDto));
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

}
