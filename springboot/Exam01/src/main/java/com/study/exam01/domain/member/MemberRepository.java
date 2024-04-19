package com.study.exam01.domain.member;

import com.study.exam01.domain.community.Notice;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {

    boolean existsByMemberId(String userID);

    Optional<Member> findByMemberIdAndMemberPw(String s, String s1);

    Optional<Member> findByMemberNameAndMemberEmailAndMemberId(String s, String s1, String s2);

    Optional<Member> findByMemberNameAndMemberEmail(String s, String s1);

    Page<Member> findAllByMemberIdContaining(Pageable pageable, String searchValue);

    Page<Member> findAllByMemberNameContaining(Pageable pageable, String searchValue);

    Page<Member> findAllByMemberEmailContaining(Pageable pageable, String searchValue);


}