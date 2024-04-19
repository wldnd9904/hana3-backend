package com.study.exam01.domain.admin;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AdminRepository extends JpaRepository<Admin, Long> {
    boolean existsByMemberId(String userID);

    Optional<Admin> findByMemberIdAndMemberPw(String s, String s1);

}
