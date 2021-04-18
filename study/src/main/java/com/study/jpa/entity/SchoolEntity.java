package com.study.jpa.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "school")
@AllArgsConstructor
@NoArgsConstructor
public class SchoolEntity extends BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "SCHOOL_SEQ")
	private Long schoolSeq;

	@Column(name = "NAME", nullable = false)
	private String name;

	@OneToMany() // (1)
	@JoinColumn(name = "SCHOOL_SCHOOL_SEQ")
	// @OneToMany(mappedBy="school")
	private List<StudentEntity> studentEntityList = new ArrayList<StudentEntity>();

	@OneToMany
	@JoinColumn(name = "SCHOOL_SCHOOL_SEQ")
	private List<TeacherEntity> teacherEntityList = new ArrayList<TeacherEntity>();

}
