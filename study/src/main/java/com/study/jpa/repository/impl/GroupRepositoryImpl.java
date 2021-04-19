package com.study.jpa.repository.impl;

import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.transaction.annotation.Transactional;

import com.study.jpa.entity.GroupEntity;
import com.study.jpa.repository.custom.GroupCustomRepository;

@Transactional(readOnly = true)
public class GroupRepositoryImpl extends QuerydslRepositorySupport implements GroupCustomRepository {


	public GroupRepositoryImpl() {
		super(GroupEntity.class);
	}



}
