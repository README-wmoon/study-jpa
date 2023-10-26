package com.jpa.intermediate.auditing;

import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.time.LocalDateTime;

//    @MappedSuperClass
//    자바 진영에서는 상속관계이지만, RDB 진영에는 상속관계가 아님을 표시할 때 사용.
//    각 필드를 개별적으로 사용하거나 바로 접근해야 할 때 사용.

@MappedSuperclass
@Getter
public class Period {
    @Column(updatable = false)
    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;

    @PrePersist
    public void create(){
        this.createdDate = LocalDateTime.now();
        this.updatedDate = LocalDateTime.now();
    }

    @PreUpdate
    public void update(){
        this.updatedDate = LocalDateTime.now();
    }

}























