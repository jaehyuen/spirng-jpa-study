package com.study.jpa.repository.impl;

import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.transaction.annotation.Transactional;

import com.study.jpa.entity.TeacherEntity;
import com.study.jpa.repository.custom.TeacherCustomRepository;

@Transactional(readOnly = true)
public class TeacherRepositoryImpl extends QuerydslRepositorySupport implements TeacherCustomRepository {


	public TeacherRepositoryImpl() {
		super(TeacherEntity.class);
	}



}
