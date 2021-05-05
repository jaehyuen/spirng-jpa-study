package com.study.jpa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
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
/**
 * @Entity 어노테이션 옵션
 * 
 * name (String) = jpa에서 사용할 이름 설정, 기본값은 클래스명
 *
 */
@Entity

/**
 * @Table 어노테이션 - 테이블 맵핑시 사용
 * 
 * name (String)                           = 엔티티와 맵핑할 테이블 명, 기본값은 엔티티 명
 * catalog (String)                        = catalog 기능이 있는 디비에서 catalog를 맵핑, 기본값은 기본 catalog사용
 * schema (String)                         = schema 기능이 있는 디비에서 schema를 맵핑, 기본값은 기본 schema사용
 * indexes (Index[])                       = 테이블에 대한 인덱스 설정, 기본키 인덱스는 자동으로 생성됨
 * uniqueConstraints (UniqueConstraints[]) = 테이블 생성시 unique 제약조건 설정, 스키마 자동생성 기능을 사용할떄만 가능
 * 
 * @Index 어노테이션 - 인덱스 설정시 사용
 * 
 * name (String)       = 인덱스명 설정
 * columnList (String) = 인덱스에 사용되는 컬럼을 순서대로 작성 (필수값)
 * unique (boolean)    = 인덱스의 unique여부 설정
 *  
 * @UniqueConstraint 어노테이션 - 유니크 제약조건 생성시 사용
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
	 * @GeneratedValue 어노테이션 - pk값 자동 생성 전략을 명시하는데 사용
	 * 
	 * strategy (GenerationType) = 자동 생성 전략 설정, 기본값은 AUTO
	 * generator (String)        = 생성기 설정( @TableGenerator, @SequenceGenerator ) 
	 *
 	 * 자동 생성값 (IDENTITY, SEQUNCE 전략은 디비 종류에따라 가능)
	 * GenerationType.IDENTITY = 기본 키 생성을 디비에 위임 (null값을 넣으면 디비에서 auto_increment 해줌)
	 * GenerationType.SEQUNCE  = 디비의 시퀀스 오브젝트를 이용?
	 * GenerationType.TABLE    = 키 생성 테이블을 생성하여 시퀀스를 모방 (모든 디비에서 사용 가능하지만 성능 이슈가 있을수도)
	 * GenerationType.AUTO     = 위 3가지 전략중 자동으로 지정 (dialect에 따라서 지정됨)
	 * 
	 * @SequenceGenerator 어노테이션 - GenerationType.SEQUNCE 전략 사용할때 시퀀스 생성시 사용
	 * 
	 * name (String)         = 시퀀스 생성기 이름 (필수값)
	 * allocationSize (int)  = 시퀀스 한 번 호출에 증가하는 수, 기본값은 50
	 * sequenceName (String) = 디비에 등록되어 있는 시퀀스 이름
	 * initialValue (int)    = 시퀀스 초기값, 기본값은 1
	 * catalog (String)      = catalog 기능이 있는 디비에서 catalog를 맵핑, 기본값은 기본 catalog사용
	 * schema (String)       = schema 기능이 있는 디비에서 schema를 맵핑, 기본값은 기본 schema사용
	 * 
	 * @TableGenerator 어노테이션 - GenerationType.TABLE 전략 사용할때 테이블 생성시 사
	 * 
	 * name (String)          = 테이블 생성기 이름 (필수값)
	 * table (String)         = 테이블 명
	 * 
	 * allocationSize (int)   = 테이블의 키값 증가하는 수, 기본값은 50
	 * initialValue (int)     = 시퀀스 초기값, 기본값은 0
	 * catalog (String)       = catalog 기능이 있는 디비에서 catalog를 맵핑, 기본값은 기본 catalog사용
	 * schema (String)        = schema 기능이 있는 디비에서 schema를 맵핑, 기본값은 기본 schema사용
	 *
	 * pkColumnName (String)  = pk 컬럼명 설정
	 * pkColumnValue (String) = 컬럼 초기화시 사용할 값 설정
	 * 
	 * indexes (Index[])                       = 테이블에 대한 인덱스 설정, 기본키 인덱스는 자동으로 생성됨
	 * uniqueConstraints (UniqueConstraints[]) = 테이블 생성시 unique 제약조건 설정, 스키마 자동생성 기능을 사용할떄만 가능
	 * 
	 */	
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	
	/**
	 * @Column 어노테이션 - 컬럼 맵핑시 사용
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
	
	@OneToOne
	@ManyToOne(targetEntity = SchoolEntity.class)
	@JoinColumn(name = "SCHOOL_SCHOOL_SEQ")
	private SchoolEntity schoolEntity;
	
}

/**
 * @OneToOne 어노테이션 - 일대일( 1 : 1 ) 조인 맵핑시 사용
 * 
 * targetEntity (Class)    = 연결 대상의 엔티티 설정, 기본값은 필드 타입
 * optional (boolean)      = 연관관계가 항상 존재하는지 여부, 기본값은 true
 * orphanRemoval (boolean) = 고아 객체를 삭제하는 설정, 기본값은 false
 * mappedBy (String)       = 연관관계의 역방항(주인이 아닌)엔티티에 설정
 * 
 * cascade (CascadeType[]) = 엔티티의 cascade 전략 설정
 * fetch (FetchType)       = 엔티티의 fetch 전략 설정,기본값은 FetchType.EAGER
 * 
 * @ManyToOne 어노테이션 - 다대일( N : 1 ) 조인 맵핑시 사용
 * 
 * targetEntity (Class)    = 연결 대상의 엔티티 설정, 기본값은 필드 타입
 * optional (boolean)      = 연관관계가 항상 존재하는지 여부, 기본값은 true
 * 
 * cascade (CascadeType[]) = 엔티티의 cascade 전략 설정 (영속성 전이)
 * fetch (FetchType)       = 엔티티의 fetch 전략 설정,기본값은 FetchType.EAGER
 * 
 * CascadeType
 * 
 * CascadeType.ALL     = 모든 작업을 전파
 * CascadeType.PERSIST = 부모 엔티티가 persist() 수행시 자식 엔티티도 persist() 수행
 * CascadeType.MERGE   = 부모 엔티티가 merge() 수행시 자식 엔티티도 merge() 수행
 * CascadeType.REMOVE  = 부모 엔티티 삭제시 자식 엔티티도 삭제
 * CascadeType.REFRESH = ??
 * CascadeType.DETACH  = 부모 엔티티가 detach() 수행시 자식 엔티티도 detach() 수행
 * 
 * ※ persist() - 엔티티를 영속성 컨텍스트에 저장
 * ※ detach()  - 영속 상태의 엔티티를 준영속 상태로 변경(영속성 컨텍스트가 관리하지 않는 상태)
 * ※ merge()   - 준영속 상태의 엔티티를 영성 상태러 변경
 * ※ remove()  - 엔티티를 삭제(디비에서도 삭제됨) 
 * 
 * FetchType
 * 
 * FetchType.EAGER = 연관 관계에 있는 엔티티를 한번에 조회
 * FetchType.LAZY  = 연관 관계에 있는 엔티티를 getter 사용시 조회
 */

/**
 * 영속성 컨텍스트란?
 * 
 * '엔티티를 영구 저장하는 환경' 이라는 뜻으로 애플리케이션과 디비사이에 엔티티를 보관하는 가상의 디비 역할을 한다.
 * 엔티티 매니저를 통해 엔티티를 저장, 조회시 엔티티 매니저는 영속성 컨텍스트에서 엔티티를 관리한다.
 * 
 * 엔티티의 생명주기
 * 
 * 비영속 (new/transient) - 엔티티 객체를 생성했지만 아직 영속성 컨텍스트에 저장하지 않은 상태
 * 영속 (managed)        - 엔티티 매니저를 통해서 엔티티를 영속성 컨텍스트에 저장한 상태
 * 준영속 (detached)      - 영속성 컨텍스트가 관리하던 영속 상태의 엔티티 더이상 관리하지 않으면 상태
 * 삭제 (removed)        - 엔티티를 영속성 컨텍스트와 데이터베이스에서 삭제된 상태
 *
 * 준영속 상태의 특징
 * 1차 캐시, 쓰기 지연, 변경 감지, 지연 로딩을 포함한 영속성 컨텍스트가 제공하는 어떠한 기능도 동작하지 않는다.
 * 식별자 값을 가지고 있다.
 *
 */