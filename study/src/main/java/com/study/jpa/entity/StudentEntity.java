package com.study.jpa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper=true)
@Entity
@Table(name = "student")
@AllArgsConstructor
@NoArgsConstructor
public class StudentEntity extends BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "STUDENT_SEQ")
	private Long studentSeq;
	
	@Column(name = "NAME", nullable = false)
	private String name;
	
	@ManyToOne(targetEntity = GroupEntity.class)
	@JoinColumn(name = "GROUP_GROUP_SEQ")
	private GroupEntity group;
	
	@Column(name = "AGE", nullable = false)
	private int age;
	
	@Column(name = "GRADE", nullable = true)
	private int grade;
	
	@Column(name = "SCHOOL", nullable = true)
	private String school;

}
