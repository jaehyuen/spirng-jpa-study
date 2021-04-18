package com.study.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.study.jpa.entity.SchoolEntity;

public interface SchoolRepository extends JpaRepository<SchoolEntity, Long> {

	SchoolEntity findByName(String name);
}
