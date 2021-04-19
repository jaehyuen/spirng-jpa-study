package com.study.jpa.repository.impl;

import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.transaction.annotation.Transactional;

import com.study.jpa.entity.StudentEntity;
import com.study.jpa.repository.custom.StudentCustomRepository;

@Transactional(readOnly = true)
public class StudentRepositoryImpl extends QuerydslRepositorySupport implements StudentCustomRepository {


	public StudentRepositoryImpl() {
		super(StudentEntity.class);
	}



}
