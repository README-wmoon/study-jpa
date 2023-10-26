package com.jpa.basic.repository;

import com.jpa.basic.entity.Member;
import com.jpa.basic.type.MemberType;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Slf4j
@Transactional
@Rollback(false)
public class MemberDAOTests {
    @Autowired
    private MemberDAO memberDAO;

    @Test
    public void saveTest(){
        Member member = new Member();
        member.setMemberName("한동석");
        member.setMemberEmail("tedhan1204@gmail.com");
        member.setMemberAge(20);
        member.setMemberPassword("1234");
        member.setMemberType(MemberType.MEMBER);

        memberDAO.save(member);
    }

    @Test
    public void findByIdTest(){
        final Optional<Member> foundMember = memberDAO.findById(29L);
        foundMember.ifPresentOrElse(
                member -> assertThat(member.getMemberAge()).isEqualTo(20),
                () -> {log.info("존재하지 않는 회원입니다.");});
    }

    @Test
    public void updateTest(){
        final Optional<Member> foundMember = memberDAO.findById(29L);
        foundMember.ifPresent(member -> {
            member.setMemberAge(30);
            assertThat(member.getMemberAge()).isEqualTo(30);
        });
    }

    @Test
    public void deleteTest(){
        memberDAO.findById(29L).ifPresent(memberDAO::delete);
    }
}
