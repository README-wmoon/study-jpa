package com.jpa.intermediate.repository;

import com.jpa.intermediate.entity.user.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface CompanyRepository extends JpaRepository<Company, Long> {
    //    경기도에 위치한 기업 회원의 아이디 뒤에 3을 붙이자!
    @Query("update Company c set c.userId = concat(c.userId, :number) where c.address.address = :address")
    public void updateUserIdByAddress(int number, String address);
}