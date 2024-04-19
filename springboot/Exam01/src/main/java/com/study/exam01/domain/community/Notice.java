package com.study.exam01.domain.community;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@Entity
@Builder
@Table(name = "company_notice")
@AllArgsConstructor
@NoArgsConstructor
public class Notice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "notice_idx")
    Long noticeIdx;
    @Column(name = "notice_title")
    String noticeTitle;
    @Column(name = "notice_content")
    String noticeContent;
    @Column(name = "notice_member_id")
    String noticeMemberId;
    @Column(name = "notice_date")
    @Builder.Default
    LocalDate noticeDate = LocalDate.now();
}
