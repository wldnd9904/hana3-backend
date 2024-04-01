package com.study.ex12_h2db;

import org.springframework.data.jpa.repository.JpaRepository;

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
}
