package com.jpa.basic.entity;

import com.jpa.basic.type.MemberType;
import com.sun.istack.NotNull;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Getter @ToString @Setter
@Table(name ="TBL_MEMBER") // 테이블 명 작성
public class Member {
    @Id @GeneratedValue // @Id는 PK로 설정할 필드 위에 작성하고, ORACLE에서 SEQ 자동 증가는 @GeneratedValue를 사용한다.
    @EqualsAndHashCode.Include
    private Long id;
    @NotNull // JAVA 에서의 validation(DB와 상관 없음)
//    @Column(nullable = false) -> 위에꺼랑 같다.
    private String memberName;
    @Column(unique = true, nullable = false) // DBMS에서의 NOT NULL 제약조건 추가(JAVA와 상관없음)
    private String memberEmail;
    private String memberPassword;
    private int memberAge;
    @Enumerated(value = EnumType.STRING)
    private MemberType memberType;
}
