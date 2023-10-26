package com.app.security.entity;

import com.app.security.constant.Role;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Table(name = "TBL_MEMBER")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member {
    @Id
    @GeneratedValue
    @EqualsAndHashCode.Include
    private Long id;
    private String memberName;
    private LocalDate memberBirth;
    @Column(unique = true)
    private String memberPhoneNumber;
    @Column(unique = true)
    private String memberId;
    private String memberPassword;
    @NotNull
    @Column(unique = true)
    private String memberEmail;
    @Enumerated(EnumType.STRING)
    private Role memberRole;

    @Builder
    public Member(@NotNull String memberName, @NotNull LocalDate memberBirth, @NotNull String memberPhoneNumber, @NotNull String memberId, @NotNull String memberPassword, @NotNull String memberEmail, @NotNull Role memberRole) {
        this.memberName = memberName;
        this.memberBirth = memberBirth;
        this.memberPhoneNumber = memberPhoneNumber;
        this.memberId = memberId;
        this.memberPassword = memberPassword;
        this.memberEmail = memberEmail;
        this.memberRole = memberRole;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public void setMemberPhoneNumber(String memberPhoneNumber) {
        this.memberPhoneNumber = memberPhoneNumber;
    }

    public void setMemberEmail(String memberEmail) {
        this.memberEmail = memberEmail;
    }

    public void setMemberBirth(LocalDate memberBirth) {
        this.memberBirth = memberBirth;
    }

    public Member update(String memberName, String memberPhoneNumber, String memberEmail){
        this.setMemberName(memberName);
        this.setMemberPhoneNumber(memberPhoneNumber);
        this.setMemberEmail(memberEmail);
        return this;
    }
}











