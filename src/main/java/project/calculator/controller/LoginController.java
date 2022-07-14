package project.calculator.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import project.calculator.domain.HistoryDto;
import project.calculator.domain.member.LoginForm;
import project.calculator.domain.member.Member;
import project.calculator.mapper.HistoryEntityMapper;
import project.calculator.service.HistoryService;
import project.calculator.service.LogService;
import project.calculator.service.LoginService;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class LoginController {
    private final LoginService loginService;
    private final HistoryService historyService;
    private final LogService log;
    private final HistoryEntityMapper mapper;

    @GetMapping("/login")
    public String loginForm(@ModelAttribute("loginForm") LoginForm form) {
        return "loginForm";
    }

    @PostMapping("/login")
    public String login(@Valid @ModelAttribute LoginForm form,
                        BindingResult bindingResult,
                        HttpServletResponse response, Model model) {
        if (bindingResult.hasErrors()) {
            return "loginForm";
        }

        Member loginMember = loginService.login(form.getLoginId(), form.getPassword());

        if (loginMember == null) {
            bindingResult.reject("loginFail", "아이디 또는 비밀번호가 맞지 않습니다.");
            return "loginForm";
        }
        log.info(loginMember.toString());

        Cookie idCookie = new Cookie("memberId", loginMember.getLoginId());
        response.addCookie(idCookie);
        List<HistoryDto> historyDtos = mapper.HistoryEntityListToHistoryDtoList(historyService.findHistoryAll());
        model.addAttribute("history", historyDtos);

        return "redirect:/";
    }

    @GetMapping("/logout")
    public String logout(HttpServletResponse response, Model model) {
        expireCookie(response, "memberId");
        List<HistoryDto> historyDtos = mapper.HistoryEntityListToHistoryDtoList(historyService.findHistoryAll());
        model.addAttribute("history", historyDtos);
        return "redirect:/";
    }

    private void expireCookie(HttpServletResponse response, String cookieName) {
        Cookie cookie = new Cookie(cookieName, null);
        cookie.setMaxAge(0);
        response.addCookie(cookie);
    }
}
