package com.jpa.intermediate.entity.user;

import com.jpa.intermediate.repository.CompanyRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Slf4j
@Transactional
@Rollback(false)
public class CompanyRepositoryTests {
    @Autowired
    private CompanyRepository companyRepository;

    @Test
    public void saveTest(){

    }

}
















