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
@Table(name = "teacher")
@AllArgsConstructor
@NoArgsConstructor
public class TeacherEntity extends BaseEntity {

	@Id // id(pk)로 지정
	
	/**
	 * 자동 생성값 (IDENTITY, SEQUNCE 전략은 디비 종류에따라 가능)
	 * GenerationType.IDENTITY = 기본 키 생성을 디비에 위임 (null값을 넣으면 디비에서 auto_increment 해줌)
	 * GenerationType.SEQUNCE  = 디비의 시퀀스 오브젝트를 이용?
	 * GenerationType.TABLE    = 키 생성 테이블을 생성하여 시퀀스를 모방 (모든 디비에서 사용 가능하지만 성능 이슈가 있을수도)
	 * GenerationType.AUTO     = 위 3가지 전략중 자동으로 지정 (dialect에 따라서 지정됨)
	 */
	
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	@Column(name = "TEACHER_SEQ") // 컬럼 이름 설정
	private Long teacherSeq;
	
	@Column(name = "NAME", nullable = false)
	private String name;
	
	@ManyToOne(targetEntity = GroupEntity.class)
	@JoinColumn(name = "GROUP_GROUP_SEQ")
	private GroupEntity group;
	
	@Column(name = "AGE", nullable = false)
	private int age;
	
	@Column(name = "SUBJECT", nullable = true)
	private String subject;
	
	/**
	 * 연관관계 맵핑
	 * 
	 * 단방향 관계     = 두 엔티티중에 한쪽만 참조하는 것
	 * 양방향 관계     = 두 엔티티 양쪽이 참조하는 것
	 * 
     * 연관관계의 주인  = 외래키를 가지고있는 엔티티?, mappedBy 를 사용안하는 쪽이 주인이됨
	 * 
	 * Many To One  = 다대일( N : 1 ) << 요건 항상 연관관계의 주인이 되기때문에 mappedBy 옵션이 없
	 * One To Many  = 일대다( 1 : N )
	 * One To One   = 일대일( 1 : 1 ) 
	 * Many To Many = 다대다( N : N )
	 * 
	 * 
	 * 양방향 관계에서는 무조껀 다쪽에 외래키를 가지고있는다
	 * 
	 * 양방향 관계에서 entity를 그대로 리턴하면 무한루프에 걸린다..
	 */
	
	@ManyToOne(targetEntity = SchoolEntity.class)
	@JoinColumn(name = "SCHOOL_SCHOOL_SEQ")
	private SchoolEntity schoolEntity;

}
