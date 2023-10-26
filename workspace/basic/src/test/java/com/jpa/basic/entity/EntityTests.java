package com.jpa.basic.entity;

import com.jpa.basic.type.MemberType;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Slf4j
public class EntityTests {

    @PersistenceContext
    private EntityManager entityManager;

    @Test
    @Transactional
    @Rollback(false)
    public void superCarEntityTest(){
//        SuperCar superCar = new SuperCar();
//        superCar.setSuperCarBrand(SuperCarType.FERRARI);
//        superCar.setSuperCarName("스파이더 488");
//        superCar.setSuperCarColor("RED");
//        superCar.setSuperCarPrice(700_000_000L);
//        superCar.setSuperCarReleaseDate(LocalDateTime.now());
//
//        entityManager.persist(superCar);

        final SuperCar foundSuperCar = entityManager.find(SuperCar.class, 27L);

        foundSuperCar.setSuperCarPrice(600_000_000L);
        entityManager.flush();
        entityManager.remove(foundSuperCar);
//        clear()하기 전 쓰기 지연 저장소의 SQL을 모두 실행시켜주는 것이 올바른 목적이다.
        entityManager.flush();
        //만약 flush()를 사용하지 않고 remove()를 사용한 뒤 clear()를 사용하면,
        //쓰기 지연 저장소에 있던 DELETE 쿼리도 없어진다.
        entityManager.clear();
    }

    @Test
    @Transactional
    @Rollback(false)
    public void memberEntityTest(){
        Member member1 = new Member();
//        Member member2 = new Member();
//
        member1.setMemberName("한동석");
        member1.setMemberEmail("tedhan1204@gmail.com");
        member1.setMemberAge(20);
        member1.setMemberPassword("1234");
        member1.setMemberType(MemberType.MEMBER);
//
//        member2.setMemberName("홍길동");
//        member2.setMemberEmail("hgd9999@gmail.com");
//        member2.setMemberAge(40);
//        member2.setMemberPassword("9999");
//        member2.setMemberType(MemberType.ADMIN);
//
        entityManager.persist(member1);
//        entityManager.persist(member2);

        Member foundMember1 = entityManager.find(Member.class, 25L);
//        1차 캐시에 조회된 엔티티가 이미 있다면, SQL 조회 없이 1차 캐시에서 가져온다.
        final Member foundMember2 = entityManager.find(Member.class, 25L);

//        1차 캐시에 등록된 엔티티가 있다면, 동일성이 보장된다.
        assertThat(foundMember1).isEqualTo(foundMember2);
        log.info("result: {}", foundMember1 == foundMember2);

//        변경 감지
        foundMember1.setMemberAge(30);

//        1차 캐시는 그대로 유지하되, 쓰기 지연 저장소에 있었던 SQL을 즉시 DB로 전송
//        commit() 전에 실행하고자 할 때 사용한다.
        entityManager.flush();

//        1차 캐시 전체 삭제
//        update 쿼리 이전에 clear()가 실행되기 때문에 flush() 후 clear()를 진행해야 한다.
//        clear()는 commit() 전에 실행되기 때문이다.
        entityManager.clear();

        foundMember1 = entityManager.find(Member.class, 25L);

//        entityManager.clear();

        entityManager.remove(foundMember1);
    }
}


















