package com.jpa.basic.repository;

import com.jpa.basic.entity.Member;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Optional;

@Repository
public class MemberDAO {
//    1. application.yml 파일에 작성된 Connection 정보를 통해 EntityManagerFactory가 생성된다.
//    2. EntityManagerFactory를 통해 EntityManager 객체가 생성된다.
    @PersistenceContext
    private EntityManager entityManager;

//    등록
    public Member save(Member member){
        entityManager.persist(member);
        return member;
    }

//    조회
    public Optional<Member> findById(Long id){
        return Optional.ofNullable(entityManager.find(Member.class, id));
    }

//    삭제
    public void delete(Member member){
        entityManager.remove(member);
    }
}
