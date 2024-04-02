package com.study.ex12_h2db;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

//JpaRepository: 스프링 JPA 라이브러리에서 Entity에 대한 기본적인 조회, 삽입, 수정, 삭제가 가능하도록 만든 인터페이스
public interface MemberRepository extends JpaRepository<MemberEntity, Long> {
    //JpaRepository의 기본 함수
    // 1. findAll() : SQL(Select * from Table) 문 실행
    // 2. findBy<ColumnName>() : SQL(Select <ColumnName> from Table) 문 실행
    // ex) findById((long)2) : select * from member where id=2;
    // ex) findByUser_id("hong) : select * from member where user_id="hong";
    // 3. save() : SQL insert&update 문 실행, id값 보고 없으면 추가, 있으면 수정
    // 4. delete() : sql delete
    List<MemberEntity> findByUserId(String userId);

    List<MemberEntity> findFirst3ByUserIdAndUserNameOrderByIdDesc(String userId, String userName);

    Boolean existsByJoinDateLessThanEqual(LocalDate date);
    long countByUserNameIgnoreCaseLike(String userid);

    @Query(value="select m from MemberEntity m where m.userId = :userid")
    List<MemberEntity> findByUserId_JPQL_Query(String userid);

    @Query(value = "select * from member where user_id = :userid", nativeQuery = true)
    List<MemberEntity> findByUserId_NATIVE_Query(String userid);

    @Modifying
    @Transactional
    @Query(value= "update member set user_id = :userid where id = :id", nativeQuery = true)
    void updateById_NATIVE_Query(String userid, long id);

    List<MemberEntity> findByUserPw(String userPw);

    @Query(value="select m from MemberEntity m where year(m.joinDate) = :year and month(m.joinDate) = :month")
    List<MemberEntity> findByYearAndMonth_JPQL(int year, int month);

    @Modifying
    @Transactional
    @Query(value= "update member set user_name = :username, user_pw = :userpw where user_id = :userid", nativeQuery = true)
    int updateUserNameUserPwByUserId_nativeQuery(String userid, String username, String userpw);

}
