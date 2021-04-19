package com.study.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.study.jpa.entity.GroupEntity;
import com.study.jpa.repository.custom.GroupCustomRepository;

public interface GroupRepository extends JpaRepository<GroupEntity, Long>, GroupCustomRepository {

}
