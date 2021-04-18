package com.study.jpa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper=true)
@Entity
@Table(name = "teacher")
@AllArgsConstructor
@NoArgsConstructor
public class TeacherEntity extends BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "TEACHER_SEQ")
	private Long teacherSeq;
	
	@Column(name = "NAME", nullable = false)
	private String name;
	
	@ManyToOne(targetEntity = GroupEntity.class)
	@JoinColumn(name = "GROUP_GROUP_SEQ")
	private GroupEntity group;
	
	@Column(name = "AGE", nullable = false)
	private int age;
	
	@Column(name = "SUBJECT", nullable = true)
	private int subject;
	
////	@ManyToOne(targetEntity = SchoolEntity.class)
////	@JoinColumn(name = "SCHOOL_SCHOOL_SEQ")
//	@Column(name = "SCHOOL_SCHOOL_SEQ")
//	private String school;

}
