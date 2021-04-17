package com.study.jpa.entity;



import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.MappedSuperclass;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import lombok.Data;

@Data
@MappedSuperclass
public class BaseEntity {

    @CreatedDate
    @Column(name ="CREATE_AT", nullable = false)
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column(name ="MODIFIED_AT", nullable = false)
    private LocalDateTime modifiedAt;
}
