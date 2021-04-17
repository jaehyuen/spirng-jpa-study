package com.study.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.study.jpa.entity.TeacherEntity;

public interface TeacherRepository extends JpaRepository<TeacherEntity, Long> {

}
