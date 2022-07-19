package project.calculator.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import project.calculator.domain.member.Member;
import project.calculator.repository.MemberRepository;
import project.calculator.repository.MemoryMemberRepository;
import project.calculator.service.MemberService;

import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
@RequestMapping("/members")
public class MemberController {
    private final MemberService memberService;

    @GetMapping("/add")
    public String addForm(@ModelAttribute("member") Member member) {
        return "addMemberForm";
    }

    @PostMapping("/add")
    public String save(@Valid @ModelAttribute Member member, BindingResult result) {
        if (result.hasErrors()) {
            return "addMemberForm";
        }

        if (memberService.join(member) == null)
            return "addMemberForm";
        return "redirect:/";
    }
}
