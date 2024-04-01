package com.study.ex12_h2db;

//DTO: 데이터 전송시 사용, 로직 없음
//VO: 데이터 안바뀜, 로직 포함, 정적 데이터 보관 시 사용
//Entity 클래스: DB랑 1:1 매칭, 로직 없음, JPA 에서 사용


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

//@Entity: DB 1:1 JPA class
//@Table: 클래스 이름이 테이블이름으로 기본설정되는데 그거 바꿔줌
@Entity
@Table(name = "member")
@Getter
//@Setter : 비추천 - 엔티티 객체에 set함수 쓰면 실제 DB에 중복적용함
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MemberEntity {
    @Id // 기본키로 사용한다는 으미ㅣ
    //@GeneratedValue: 해당 ID값 생성 전략
    // 1.IDENTITY : MySQL, MariaDB, PostreSQL, H2DB
    // 2.SEQUENCE : Oracle, PostreSQL
    // 3. AUTO : 자동
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;            //bigint
    // @Column: DB 컬럼이랑 이름 매칭해줌
    @Column(name = "user_id")
    private String user_id;     //varchar
    @Column
    private String user_pw;
    @Column
    private String user_name;
    @Column
    private String user_role;
    @Column
    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private LocalDate joindate;
}
