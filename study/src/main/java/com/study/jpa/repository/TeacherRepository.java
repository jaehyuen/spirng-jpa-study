package com.study.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.study.jpa.entity.TeacherEntity;
import com.study.jpa.repository.custom.TeacherCustomRepository;

public interface TeacherRepository extends JpaRepository<TeacherEntity, Long>, TeacherCustomRepository {

}
