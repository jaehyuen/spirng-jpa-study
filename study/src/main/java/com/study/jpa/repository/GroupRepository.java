package com.study.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.study.jpa.entity.GroupEntity;

public interface GroupRepository extends JpaRepository<GroupEntity, Long> {

}
