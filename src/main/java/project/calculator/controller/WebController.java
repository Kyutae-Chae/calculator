package project.calculator.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import project.calculator.domain.FormDto;
import project.calculator.domain.RequestDto;
import project.calculator.domain.ResponseDto;
import project.calculator.service.CalculatorService;

import javax.validation.Valid;

@Controller
@RequestMapping("/")
@RequiredArgsConstructor
public class WebController {
    private final CalculatorService calculatorService;

    @GetMapping("/calculate")
    public String calculate(@RequestBody @Valid RequestDto requestDto, Model model) {
        FormDto formDto = new FormDto();
        model.addAttribute("formDto", formDto);
        return "index";
    }

    @PostMapping("/calculate")
    public String getResult(@RequestBody @Valid RequestDto requestDto,
                            BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "index";
        }

        FormDto formDto = new FormDto();
        formDto.setOperator(requestDto.getOperator());
        formDto.setOperand1(requestDto.getOperand1());
        formDto.setOperand2(requestDto.getOperand2());
        formDto.setResult(calculatorService.calculate(requestDto));
        model.addAttribute("formDto", formDto);
        return "redirect:/";
    }
}
