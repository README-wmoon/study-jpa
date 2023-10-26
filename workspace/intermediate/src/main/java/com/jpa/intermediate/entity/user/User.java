package com.jpa.intermediate.entity.user;

import lombok.EqualsAndHashCode;
import lombok.Setter;
import lombok.Getter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "TBL_USER")
@Getter @Setter @ToString
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class User {
    @Id @GeneratedValue
    @EqualsAndHashCode.Include
    private Long id;
    private String userId;
    private String userPassword;
    private String userName;
    @Embedded
    private Address address;
}
