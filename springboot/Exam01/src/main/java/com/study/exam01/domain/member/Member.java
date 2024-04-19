package com.study.exam01.domain.member;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Getter
@Entity
@Builder
@Table(name = "company_member")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_idx")
    private Long memberIdx;
    @Column(name = "member_id")
    private String memberId;
    @Column(name = "member_pw")
    private String memberPw;
    @Column(name = "member_name")
    private String memberName;
    @Column(name = "member_email")
    private String memberEmail;
    @Column(name = "member_email_receive")
    private int memberEmailReceive;
    @Column(name = "member_pw_question")
    private int memberPwQuestion;
    @Column(name = "member_pw_answer")
    private String memberPwAnswer;
    @Column(name = "member_gender")
    private String memberGender;
    @Column(name = "member_birth_date")
    private LocalDate memberBirthDate;
    @Column(name = "member_join_date")
    @Builder.Default
    private LocalDate memberJoinDate = LocalDate.now();

}
