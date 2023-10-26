package com.app.security.service;

import com.app.security.domain.MemberDTO;
import com.app.security.entity.Member;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

public interface MemberService extends UserDetailsService {
//    회원가입
    public void join(MemberDTO memberDTO, PasswordEncoder passwordEncoder);

//    회원가입(OAuth)
    public void join(MemberDTO memberDTO);

    public default Member toEntity(MemberDTO memberDTO){
        return Member.builder()
                .memberName(memberDTO.getMemberName())
                .memberId(memberDTO.getMemberId())
                .memberPassword(memberDTO.getMemberPassword())
                .memberEmail(memberDTO.getMemberEmail())
                .memberBirth(memberDTO.getMemberBirth())
                .memberPhoneNumber(memberDTO.getMemberPhoneNumber())
                .memberRole(memberDTO.getMemberRole())
                .build();
    }
}
