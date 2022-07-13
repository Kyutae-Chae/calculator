package project.calculator.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import project.calculator.domain.FormDto;
import project.calculator.domain.HistoryDto;
import project.calculator.domain.RequestDto;
import project.calculator.mapper.HistoryEntityMapper;
import project.calculator.service.CalculatorService;
import project.calculator.service.HistoryService;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/")
@RequiredArgsConstructor
public class WebController {
    private final CalculatorService calculatorService;
    private final HistoryService historyService;
    private final HistoryEntityMapper mapper;

    @GetMapping("/")
    public String calculate(Model model) {
        FormDto formDto = new FormDto();
        model.addAttribute("formDto", formDto);
        List<HistoryDto> historyDtos = mapper.HistoryEntityListToHistoryDtoList(historyService.findHistoryAll());
        model.addAttribute("history", historyDtos);
        return "index";
    }

    @PostMapping("/calculate")
    public String getResult(@Valid RequestDto requestDto,
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
        List<HistoryDto> historyDtos = mapper.HistoryEntityListToHistoryDtoList(historyService.findHistoryAll());
        model.addAttribute("history", historyDtos);
        return "index";
    }

    @GetMapping("/history/{historyId}/delete")
    public String deleteHistory(@PathVariable("historyId") Long historyId, Model model) {

        //history service 삭제 구현필요

        List<HistoryDto> historyDtos = mapper.HistoryEntityListToHistoryDtoList(historyService.findHistoryAll());
        model.addAttribute("history", historyDtos);
        model.addAttribute("formDto", new FormDto());
        return "redirect:/";
    }
}
