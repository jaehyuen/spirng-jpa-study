package com.study.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.study.jpa.entity.SchoolEntity;
import com.study.jpa.repository.custom.SchoolCustomRepository;

public interface SchoolRepository extends JpaRepository<SchoolEntity, Long>, SchoolCustomRepository {

	SchoolEntity findByName(String name);
}
