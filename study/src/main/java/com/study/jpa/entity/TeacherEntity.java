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
/**
 * @Entity 어노테이션 옵션
 * 
 * name (String) = jpa에서 사용할 이름 설정, 기본값은 클래스명
 *
 */
@Entity

/**
 * @Table 어노테이션 옵션
 * 
 * name (String)                           = 엔티티와 맵핑할 테이블 명, 기본값은 엔티티 명
 * catalog (String)                        = catalog 기능이 있는 디비에서 catalog를 맵핑, 기본값은 기본 catalog사용
 * schema (String)                         = schema 기능이 있는 디비에서 schema를 맵핑, 기본값은 기본 schema사용
 * indexes (Index[])                       = 테이블에 대한 인덱스 설정, 기본키 인덱스는 자동으로 생성됨
 * uniqueConstraints (UniqueConstraints[]) = 테이블 생성시 unique 제약조건 설정, 스키마 자동생성 기능을 사용할떄만 가능
 * 
 * @Index 어노테이션 옵션
 * 
 * name (String)       = 인덱스명 설정
 * columnList (String) = 인덱스에 사용되는 컬럼을 순서대로 작성 (필수값)
 * unique (boolean)    = 인덱스의 unique여부 설정
 *  
 * @UniqueConstraint 어노테이션 옵션
 * 
 * name (String)          = 이름설정인데 정확한건 모르겟음..
 * columnNames (String[]) = unique 설정할 컬럼 리스트 (필수값)
 * 
 */
@Table(name ="teacher")
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
	
	/**
	 * @Column 어노테이션 옵션
	 * 
	 * columnDefinition (String) = 컬럼 정보를 직접 작성, 기본적으로 생성한 sql에 유추해서 집어넣는다..?
	 * name (String)             = 변수명과 맵핑할 디비 컬럼명을 설정, 기본값은 필드명이다
	 * 
	 * insertable (boolean)      = 디비 컬럼 등록 가능 여부, 기본값은  true
	 * updateable (boolean)      = 디비 컬럼 수정 가능 여부, 기본값 은 true
	 * 
	 * nullable (boolean)        = 디비 컬럼에 not null 제약조건 설정
	 * unique (boolean)          = 디비 컬럼에 unique 제약조건 설정
	 * table (String)            = 다른테이블과 맵핑시 사용
	 * 
	 * length (int)              = 문자열 길이 설정(문자열 관련 컬럼에만 사용), 기본값은 255
	 * precision (int)           = 소수점을 포함한 전체 자리수 설정 (demical 컬럼에서만 사용)
	 * scale (int)               = 소수점의 자리수 설정 (demical 컬럼에서만 사용)
	 * 
	 * ※ demical 컬럼은 자바에서 BigDecimal로 선언해야됨
	 * 
	 */
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
