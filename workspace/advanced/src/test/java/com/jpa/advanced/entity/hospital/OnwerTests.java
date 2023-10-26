package com.jpa.advanced.entity.hospital;


import com.jpa.advanced.repository.hospital.OwnerDAO;
import com.jpa.advanced.repository.hospital.PetDAO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import javax.swing.text.html.Option;
import java.util.Optional;

@SpringBootTest
@Slf4j
@Transactional
@Rollback(false)
public class OnwerTests {
    @Autowired
    private OwnerDAO ownerDAO;

    @Autowired
    private PetDAO petDAO;

    @Test
    public void saveTest() {
//        Owner owner = new Owner();
//        Pet pet1 = new Pet();
//        Pet pet2 = new Pet();
//        owner.setOwnerName("순자");
//        owner.setOwnerPhone("010-1111-2222");
//
//        ownerDAO.save(owner);
//
//        pet1.setPetName("똘똘이");
//        pet1.setPetGender("남");
//        pet1.setPetDisease("아픔");
//        petDAO.save(pet1);
//
//        pet2.setPetName("동동이");
//        pet2.setPetGender("여");
//        pet2.setPetDisease("설사");
//        petDAO.save(pet2);

//        Owner owner = new Owner();
//        owner.setOwnerName("한동석");
//        owner.setOwnerPhone("010-1111-2222");
//
//        ownerDAO.save(owner);

//        final Optional<Owner> foundOwner = ownerDAO.findById(24L);
//
//        Pet pet = new Pet();
//        pet.setPetName("톰");
//        pet.setPetGender("남자");
//        pet.setPetDisease("감기");
//
//        foundOwner.ifPresent(owner -> owner.getPets().add(pet));
        Owner owner = new Owner();
        owner.setOwnerName("이순신");
        owner.setOwnerPhone("010-1111-2222");
        ownerDAO.save(owner);


//        final Optional<Owner> foundOwner = ownerDAO.findById(22L);
   }
   @Test
   public void findAllTest(){
        petDAO.findAll().forEach(pet ->{
            log.info(pet.getOwner().getOwnerName());
        });
   }

   @Test
    public void updateTest(){
        petDAO.findById(2L).ifPresent(pet -> pet.getOwner().setOwnerName("뽀삐"));
   }

   @Test
    public void deleteTest() {
        final Optional<Owner> foundOwner = ownerDAO.findById(24L);
   }
}
