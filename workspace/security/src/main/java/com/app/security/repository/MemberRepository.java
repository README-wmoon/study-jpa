package com.app.security.repository;

import com.app.security.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long>, MemberQueryDSL {
//    아이디로 전체 정보 조회
    public Optional<Member> findByMemberId(String memberId);

//    이메일로 전체 정보 조회
    public Optional<Member> findByMemberEmail(String memberEmail);
}
