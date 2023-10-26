package com.app.security.controller;

import com.app.security.domain.MemberDTO;
import com.app.security.provider.MemberDetail;
import com.app.security.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/board/*")
public class BoardController {
    private final MemberRepository memberRepository;
    @GetMapping("list")
    public void goToListForm(@AuthenticationPrincipal MemberDetail memberDetail, HttpSession session){
//        log.info("=================== {}", memberDetail.toString());
        if(memberDetail != null){ //일반 로그인도 session에서 "member"로 정보를 가져올 수 있도록 설정
            session.setAttribute("member", new MemberDTO(memberRepository.findByMemberId(memberDetail.getMemberId()).get()));
        }
    }
}



















