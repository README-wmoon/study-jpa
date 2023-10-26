package com.app.security.controller;

import com.app.security.domain.MemberDTO;
import com.app.security.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpSession;

@Controller
@Slf4j
@RequestMapping("/member/*")
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;
    private final PasswordEncoder passwordEncoder;
    private final HttpSession session;

    @GetMapping("join")
    public String goToJoinForm(MemberDTO memberDTO){
        if(session.getAttribute("member") != null){
            return "/member/oauth-join";
        }
        return "/member/join";
    }

    @PostMapping("join")
    public RedirectView join(MemberDTO memberDTO){
        log.info("{}: ===============", session.getAttribute("member"));
        if(session.getAttribute("member") != null) {
            memberService.join(memberDTO);
            return new RedirectView("/board/list");
        }
        memberService.join(memberDTO, passwordEncoder);
        return new RedirectView("/member/login");
    }

    @GetMapping("login")
    public void goToLoginForm(){;}
}
