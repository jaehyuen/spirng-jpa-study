package com.study.jpa.repository.impl;

import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.transaction.annotation.Transactional;

import com.study.jpa.entity.SchoolEntity;
import com.study.jpa.repository.custom.SchoolCustomRepository;

@Transactional(readOnly = true)
public class SchoolRepositoryImpl extends QuerydslRepositorySupport implements SchoolCustomRepository {


	public SchoolRepositoryImpl() {
		super(SchoolEntity.class);
	}



}
