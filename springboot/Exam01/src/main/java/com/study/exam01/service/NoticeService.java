package com.study.exam01.service;

import com.study.exam01.domain.community.Notice;
import com.study.exam01.domain.community.NoticeRepository;
import com.study.exam01.domain.member.Member;
import com.study.exam01.dto.member.MemberResponseDto;
import com.study.exam01.dto.notice.NoticeEditRequestDto;
import com.study.exam01.dto.notice.NoticeResponseDto;
import com.study.exam01.dto.notice.NoticeWriteRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Comparator;
import java.util.List;

@Service
@RequiredArgsConstructor
public class NoticeService {
    private final NoticeRepository noticeRepository;

    @Transactional(readOnly = true)
    public Page<NoticeResponseDto> findPage(int page, int limit, String searchType, String searchValue) {
        Pageable pageable = PageRequest.of(page, limit);
        Page<Notice> noticePage = switch (searchType) {
            case "title" ->
                    noticeRepository.findAllByNoticeTitleContainingOrderByNoticeDateDescNoticeIdxDesc(pageable, searchValue);
            case "content" ->
                    noticeRepository.findAllByNoticeContentContainingOrderByNoticeDateDescNoticeIdxDesc(pageable, searchValue);
            case "member" -> noticeRepository.findAllLikeMemberNameOrderByNoticeDateDesc(pageable, searchValue);
            default -> noticeRepository.findAllByOrderByNoticeDateDescNoticeIdxDesc(pageable);
        };
        return noticePage.map(NoticeResponseDto::new);
    }

    @Transactional(readOnly = true)
    public Page<NoticeResponseDto> findPage2(int page, int limit, String searchType,
                                             String searchValue, String sortType) {
        Pageable pageable = switch (sortType) {
            case "idAsc" -> PageRequest.of(page, limit, Sort.by("noticeMemberId").ascending());
            case "idDesc" -> PageRequest.of(page, limit, Sort.by("noticeMemberId").descending());
            case "noticeDateAsc" -> PageRequest.of(page, limit, Sort.by("noticeDate").ascending());
            case "noticeDateDesc" -> PageRequest.of(page, limit, Sort.by("noticeDate").descending());
            default -> PageRequest.of(page, limit);
        };
        Page<Notice> noticePage = switch (searchType) {
            case "title" -> noticeRepository.findAllByNoticeTitleContaining(pageable, searchValue);
            case "content" -> noticeRepository.findAllByNoticeContentContaining(pageable, searchValue);
            case "memberId" -> noticeRepository.findAllByNoticeMemberIdContaining(pageable, searchValue);
            default -> noticeRepository.findAll(pageable);
        };
        return noticePage.map(NoticeResponseDto::new);
    }

    @Transactional(readOnly = true)
    public NoticeResponseDto findByIdx(Long idx) {
        return new NoticeResponseDto(noticeRepository.findById(idx).orElseThrow());
    }

    @Transactional
    public boolean save(NoticeWriteRequestDto dto) {
        Notice notice = noticeRepository.save(dto.toEntity());
        return noticeRepository.existsById(notice.getNoticeIdx());
    }

    @Transactional
    public boolean save(NoticeEditRequestDto dto) {
        Notice notice = noticeRepository.save(dto.toEntity());
        return noticeRepository.existsById(notice.getNoticeIdx());
    }

    @Transactional
    public boolean deleteById(Long id) {
        noticeRepository.deleteById(id);
        return !noticeRepository.existsById(id);
    }
}
