package project.calculator.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import project.calculator.domain.FormDto;
import project.calculator.domain.HistoryDto;
import project.calculator.domain.RequestDto;
import project.calculator.domain.member.Member;
import project.calculator.mapper.HistoryEntityMapper;
import project.calculator.service.CalculatorService;
import project.calculator.service.HistoryService;
import project.calculator.service.LogService;
import project.calculator.service.MemberService;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/")
@RequiredArgsConstructor
public class WebController {
    private final CalculatorService calculatorService;
    private final HistoryService historyService;
    private final MemberService memberService;
    private final HistoryEntityMapper mapper;
    private final LogService log;

//    @GetMapping("/")
//    public String home() {
//        return "redirect:/calculate";
//    }
    @GetMapping("/")
    public String homeLogin(
            @SessionAttribute(name = "loginMember", required = false) Member loginMember,
            Model model) {

        List<HistoryDto> historyDtos = mapper.HistoryEntityListToHistoryDtoList(historyService.findHistoryAll());
        model.addAttribute("history", historyDtos);
        model.addAttribute("member", loginMember);
        model.addAttribute("formDto", new FormDto());

        return "index";
    }

    @PostMapping("/calculate")
    public String getResult(@CookieValue(name = "memberId", required = false) String memberId,
                            @Valid RequestDto requestDto,
                            BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("formDto", new FormDto());
            List<HistoryDto> historyDtos = mapper.HistoryEntityListToHistoryDtoList(historyService.findHistoryAll());
            model.addAttribute("history", historyDtos);
            return "redirect:/";
        }


        List<HistoryDto> historyDtos = mapper.HistoryEntityListToHistoryDtoList(historyService.findHistoryAll());
        model.addAttribute("history", historyDtos);

        FormDto formDto = new FormDto();
        formDto.setOperator(requestDto.getOperator());
        formDto.setOperand1(requestDto.getOperand1());
        formDto.setOperand2(requestDto.getOperand2());
        formDto.setResult(calculatorService.calculate(requestDto));
        model.addAttribute("formDto", formDto);

        List<Member> optionalMember = memberService.findMember(memberId);
        if (optionalMember.isEmpty()) {
            return "redirect:/";
        }
        model.addAttribute("member", optionalMember.get(0));
        return "redirect:/";
    }

    @DeleteMapping("/history/{historyId}/delete")
    public String deleteHistory(@PathVariable("historyId") Long historyId, Model model) {
        historyService.deleteHistory(historyId);
        log.warn("delete history ID : " + historyId);

        List<HistoryDto> historyDtos = mapper.HistoryEntityListToHistoryDtoList(historyService.findHistoryAll());
        model.addAttribute("history", historyDtos);
        model.addAttribute("formDto", new FormDto());
        return "redirect:/";
    }
}
