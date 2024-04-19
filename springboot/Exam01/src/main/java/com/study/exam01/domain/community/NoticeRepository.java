package com.study.exam01.domain.community;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface NoticeRepository extends JpaRepository<Notice, Long> {

    Page<Notice> findAllByOrderByNoticeDateDescNoticeIdxDesc(Pageable pageable);

    Page<Notice> findAllByNoticeTitleContainingOrderByNoticeDateDescNoticeIdxDesc(Pageable pageable, String title);

    Page<Notice> findAllByNoticeContentContainingOrderByNoticeDateDescNoticeIdxDesc(Pageable pageable, String content);

    @Query(value = """
            select * from company_notice
            where notice_member_id in (
                select member_id from company_member_admin
                                 where member_name like CONCAT('%',:memberName ,'%')
                )order by notice_date desc, notice_idx desc"""
            , nativeQuery = true)
    Page<Notice> findAllLikeMemberNameOrderByNoticeDateDesc(Pageable pageable, String memberName);

    Page<Notice> findAllByNoticeTitleContaining(Pageable pageable, String searchValue);

    Page<Notice> findAllByNoticeContentContaining(Pageable pageable, String searchValue);

    Page<Notice> findAllByNoticeMemberIdContaining(Pageable pageable, String searchValue);
}
