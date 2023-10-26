package com.jpa.basic.repository;

import com.jpa.basic.entity.SuperCar;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Optional;

@Repository
public class SuperCarDAO {
    @PersistenceContext
    private EntityManager entityManager;

//    추가
    public SuperCar save(SuperCar superCar){
        entityManager.persist(superCar);
        return superCar;
    }

//    조회
    public Optional<SuperCar> findById(Long id){
        return Optional.ofNullable(entityManager.find(SuperCar.class, id));
    }

//    삭제
    public boolean deleteById(Long id){
        final Optional<SuperCar> foundSuperCar = findById(id);
        if(foundSuperCar.isPresent()){
            entityManager.remove(foundSuperCar.get());
            return true;
        }
        return false;
    }
}
