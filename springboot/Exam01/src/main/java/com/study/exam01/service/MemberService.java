package com.study.exam01.service;

import com.study.exam01.domain.member.Member;
import com.study.exam01.domain.member.MemberRepository;
import com.study.exam01.dto.member.MemberJoinRequestDto;
import com.study.exam01.dto.member.MemberLoginRequestDto;
import com.study.exam01.dto.member.MemberResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

    @Transactional(readOnly = true)
    public boolean existsByUserID(String userID) {
        return memberRepository.existsByMemberId(userID);
    }

    @Transactional
    public boolean join(MemberJoinRequestDto dto) {
        Long idx = memberRepository.save(dto.toEntity()).getMemberIdx();
        return memberRepository.existsById(idx);
    }

    @Transactional(readOnly = true)
    public Optional<Member> login(MemberLoginRequestDto dto) {
        return memberRepository.findByMemberIdAndMemberPw(dto.loginID(), dto.loginPW());
    }

    @Transactional(readOnly = true)
    public Member findById(Long userIdx) {
        return memberRepository.findById(userIdx).orElseThrow();
    }

    @Transactional(readOnly = true)
    public Optional<Member> findByUserNameAndUserEmail(String s, String s1) {
        return memberRepository.findByMemberNameAndMemberEmail(s, s1);
    }

    @Transactional(readOnly = true)
    public Optional<Member> findByUserNameAndUserEmailAndUserId(String s, String s1, String s2) {
        return memberRepository.findByMemberNameAndMemberEmailAndMemberId(s, s1, s2);
    }

    @Transactional(readOnly = true)
    public Page<MemberResponseDto> findPage(int page, int limit, String searchType,
                                            String searchValue, String sortType) {
        Pageable pageable = switch (sortType) {
            case "idAsc" -> PageRequest.of(page, limit, Sort.by("memberId").ascending());
            case "idDesc" -> PageRequest.of(page, limit, Sort.by("memberId").descending());
            case "joinDateAsc" -> PageRequest.of(page, limit, Sort.by("memberJoinDate").ascending());
            case "joinDateDesc" -> PageRequest.of(page, limit, Sort.by("memberJoinDate").descending());
            default -> PageRequest.of(page, limit);
        };
        Page<Member> memberPage = switch (searchType) {
            case "id" -> memberRepository.findAllByMemberIdContaining(pageable, searchValue);
            case "name" -> memberRepository.findAllByMemberNameContaining(pageable, searchValue);
            case "email" -> memberRepository.findAllByMemberEmailContaining(pageable, searchValue);
            default -> memberRepository.findAll(pageable);
        };
        return memberPage.map(MemberResponseDto::new);
    }
}
