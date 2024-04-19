package com.study.exam01.service;

import com.study.exam01.domain.admin.Admin;
import com.study.exam01.domain.admin.AdminRepository;
import com.study.exam01.domain.member.Member;
import com.study.exam01.domain.member.MemberRepository;
import com.study.exam01.dto.member.MemberJoinRequestDto;
import com.study.exam01.dto.member.MemberLoginRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AdminService {
    private final AdminRepository adminRepository;

    @Transactional(readOnly = true)
    public boolean existsByUserID(String userID) {
        return adminRepository.existsByMemberId(userID);
    }
    
    @Transactional(readOnly = true)
    public Optional<Admin> login(MemberLoginRequestDto dto) {
        return adminRepository.findByMemberIdAndMemberPw(dto.loginID(), dto.loginPW());
    }

    @Transactional(readOnly = true)
    public Admin findById(Long userIdx) {
        return adminRepository.findById(userIdx).orElseThrow();
    }
}
