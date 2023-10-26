package com.jpa.basic.entity;

import com.jpa.basic.type.SuperCarType;
import com.sun.istack.NotNull;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Getter @ToString @Setter
@Table(name="TBL_SUPER_CAR") // 테이블명 설정
public class SuperCar {
    @Id @GeneratedValue         // id값 설정과 GeneratedValue통해 값이 하나씩 전달
    @EqualsAndHashCode.Include  // hashCode를 같은
    private Long id;
    @NotNull @Enumerated(EnumType.STRING)
    private SuperCarType superCarBrand;
    private String superCarName;
    private String superCarColor;
    private Long superCarPrice;
    private LocalDateTime superCarReleaseDate;
}
