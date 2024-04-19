package com.study.exam01.domain.admin;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@Entity
@Builder
@Table(name = "company_member_admin")
@NoArgsConstructor
@AllArgsConstructor
public class Admin {
    @Id
    @Column(name = "member_idx")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long memberIdx;
    @Column(name = "member_id")
    String memberId;
    @Column(name = "member_pw")
    String memberPw;
    @Column(name = "member_name")
    String memberName;
    @Column(name = "member_email")
    String memberEmail;
    @Column(name = "member_join_date")
    @Builder.Default
    LocalDate memberJoinDate = LocalDate.now();
}
