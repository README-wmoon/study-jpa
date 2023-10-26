package com.app.security.domain;

import com.app.security.constant.Role;
import com.app.security.entity.Member;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.time.LocalDate;

@Component
@Data
@NoArgsConstructor
public class MemberDTO implements Serializable {
    private String memberName;
    @DateTimeFormat(pattern = "yyyy.MM.dd")
    private LocalDate memberBirth;
    private String memberPhoneNumber;
    private String memberId;
    private String memberPassword;
    private String memberEmail;
    private Role memberRole;

    public MemberDTO(Member member){
        this.memberId = member.getMemberId();
        this.memberName = member.getMemberName();
        this.memberPhoneNumber = member.getMemberPhoneNumber();
        this.memberEmail = member.getMemberEmail();
        this.memberBirth = member.getMemberBirth();
    }
}


















