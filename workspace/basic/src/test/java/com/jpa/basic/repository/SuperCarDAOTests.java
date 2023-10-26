package com.jpa.basic.repository;

import com.jpa.basic.entity.SuperCar;
import com.jpa.basic.type.SuperCarType;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Slf4j
@Transactional
@Rollback(false)
public class SuperCarDAOTests {

    @Autowired
    private SuperCarDAO superCarDAO;

    @Test
    public void saveTest(){
        SuperCar superCar = new SuperCar();
        superCar.setSuperCarBrand(SuperCarType.FERRARI);
        superCar.setSuperCarName("스파이더 488");
        superCar.setSuperCarColor("RED");
        superCar.setSuperCarPrice(700_000_000L);
        superCar.setSuperCarReleaseDate(LocalDateTime.now());

        superCarDAO.save(superCar);
    }

    @Test
    public void findByIdTest(){
        superCarDAO.findById(30L).ifPresent(superCar -> assertThat(superCar.getSuperCarColor()).isEqualTo("RED"));
    }

    @Test
    public void updateTest(){
        superCarDAO.findById(30L).ifPresent(superCar -> {
            superCar.setSuperCarColor("BLUE");
            assertThat(superCar.getSuperCarBrand()).isEqualTo(SuperCarType.FERRARI);
        });
    }

    @Test
    public void deleteTest(){
        log.info(superCarDAO.deleteById(30L) ? "삭제 성공" : "삭제 실패");
    }
}




















