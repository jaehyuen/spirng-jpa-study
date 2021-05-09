package com.study.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.study.jpa.entity.TeacherEntity;
import com.study.jpa.repository.custom.TeacherCustomRepository;

public interface TeacherRepository extends JpaRepository<TeacherEntity, Long>, TeacherCustomRepository {

}

/**
 * spring data JPA 쿼리 메소드 정리
 * 
 * 키워드                      | 예제 메소드                                                   | jpql 
 * -----------------------------------------------------------------------------------------------------------------------------------------
 * Distnct          | findDistinctByLastname               | select distinct testEntity where testEntity.lastname = ?1
 * * ---------------------------------------------------------------------------------------------------------------------------------------
 * And              | findByLastnameAndFirstname           | select testEntity where testEntity.lastname = ?1 and testEntity.firtstname = ?2
 * * ------------------------------------------------------------------------------------------------------------------------
 * Or               | findByLastnameOrFirstname            | select testEntity where testEntity.lastname = ?1 or testEntity.firstanme = ?2
 * * ---------------------------------------------------------------------------------------------------------------------------------------
 * Is,              | findByFirstname,                     | 
 * Equals           | findByFirstnameIs,                   | select testEntity where testEntity.firstname = ?1
 *                  | findByFirstnameEquals                |
 * ----------------------------------------------------------------------------------------------------------------------------------------
 * Between          | findByStartDateBetween               | select testEntity where testEntity.startDate between ?1 and ?2
 * ----------------------------------------------------------------------------------------------------------------------------------------
 * LessThan         | findByAgeLessThan                    | select testEntity where testEntity.age < ?1
 * ----------------------------------------------------------------------------------------------------------------------------------------
 * LessThanEqual    | findByAgeLessThanEqual               | select testEntity where testEntity.age <= ?1
 * ----------------------------------------------------------------------------------------------------------------------------------------
 * GreaterThan      | findByAgeGreaterThan                 | select testEntity where testEntity.age > ?1
 * ----------------------------------------------------------------------------------------------------------------------------------------
 * GreaterThanEqual | findByAgeGreaterThanEqual            | select testEntity where testEntity.age >= ?1
 * ----------------------------------------------------------------------------------------------------------------------------------------
 * After            | findByStartDateAfter                 | select testEntity where testEntity.startDate > ?1
 * ----------------------------------------------------------------------------------------------------------------------------------------
 * Before           | findByStartDateBefore                | select testEntity where testEntity.startDate < ?1
 * ----------------------------------------------------------------------------------------------------------------------------------------
 * IsNull,          | findByAgeIsNull                      | select testEntity where testEntity.age is null
 * Null             | findByAgeNull                        |  
 * ----------------------------------------------------------------------------------------------------------------------------------------
 * IsNotNull,       | findByAgeIsNotNull                   | select testEntity where testEntity.age not null
 * NotNull          | findByAgeNotNu                       |  
 * ----------------------------------------------------------------------------------------------------------------------------------------
 * Like             | findByFirstnameLike                  | select testEntity where testEntity.firstname like ?1
 * ----------------------------------------------------------------------------------------------------------------------------------------
 * NotLike          | findByFirstnameNotLike               | select testEntity where testEntity.firstname not like ?1
 * ----------------------------------------------------------------------------------------------------------------------------------------
 * StartingWith     | findByFirstnameStartingWith          | select testEntity where testEntity.firstabane like ?1 
 *                  |                                      | (파라미터 뒤에 %문자열이 추가됨)
 * ----------------------------------------------------------------------------------------------------------------------------------------
 * EndingWith       | findByFirstnameEndingWith            | select testEntity where testEntity.firstabane like ?1 
 *                  |                                      | (파라미터 앞에 %문자열이 추가됨)
 * ----------------------------------------------------------------------------------------------------------------------------------------
 * Containing       | findByFirstnameContaining            | select testEntity where testEntity.firstabane like ?1 
 *                  |                                      | (파라미터 앞뒤에 %문자열이 추가됨)
 * ----------------------------------------------------------------------------------------------------------------------------------------
 * OrderBy          | findByAgeOrdererByLastNameDesc       | select testEntity where testEntity.age = ?1 order by
 *                  |                                      | testEntity.lastname desc
 * ----------------------------------------------------------------------------------------------------------------------------------------
 * Not              | findByLastnameNot                    | select testEntity where testEntity.lastname <> ?1 (이건 문법을 잘 모르겟음)
 * ----------------------------------------------------------------------------------------------------------------------------------------
 * In               | findByAgeIn(Collection<Age> ages)    | select testEntity where testEntity.age in = ?1 
 * ----------------------------------------------------------------------------------------------------------------------------------------
 * NotIn            | findByAgeNotIn(Collection<Age> ages) | select testEntity where testEntity.age not in = ?1 
 * ----------------------------------------------------------------------------------------------------------------------------------------
 * True             | findByActiveTrue()                   | select testEntity where testEntity.active = true
 * ----------------------------------------------------------------------------------------------------------------------------------------
 * False            | findByActiveFalse()                  | select testEntity where testEntity.active = false
 * ----------------------------------------------------------------------------------------------------------------------------------------
 * IgnireCase       | findByFirstnameIgnoreCase            | select testEntity  where UPPER(testEntity.firstname) = UPPER(?1)
 * ----------------------------------------------------------------------------------------------------------------------------------------
 * 
 * 
 * 
 * */
