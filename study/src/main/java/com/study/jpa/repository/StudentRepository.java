package com.study.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.study.jpa.entity.StudentEntity;

public interface StudentRepository extends JpaRepository<StudentEntity, Long> {

}
