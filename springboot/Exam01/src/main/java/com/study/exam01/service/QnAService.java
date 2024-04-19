package com.study.exam01.service;

import com.study.exam01.domain.community.Notice;
import com.study.exam01.domain.community.NoticeRepository;
import com.study.exam01.domain.customer.QnA;
import com.study.exam01.domain.customer.QnARepository;
import com.study.exam01.dto.customer.QnAResponseDto;
import com.study.exam01.dto.notice.NoticeResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class QnAService {
    private final QnARepository qnaRepository;

    @Transactional(readOnly = true)
    public Page<QnAResponseDto> findPage(int page, int limit, String searchType, String searchValue) {
        Pageable pageable = PageRequest.of(page, limit);
        Page<QnA> qnaPage = switch (searchType) {
            case "title" ->
                    qnaRepository.findAllByQnaTitleContainingOrderByQnaDateDescQnaIdxDesc(pageable, searchValue);
            case "content" ->
                    qnaRepository.findAllByQnaContentContainingOrderByQnaDateDescQnaIdxDesc(pageable, searchValue);
            case "name" -> qnaRepository.findAllByQnaNameContainingOrderByQnaDateDescQnaIdxDesc(pageable, searchValue);
            default -> qnaRepository.findAllByOrderByQnaDateDescQnaIdxDesc(pageable);
        };
        return qnaPage.map(QnAResponseDto::new);
    }

    @Transactional(readOnly = true)
    public QnAResponseDto findByIdx(Long idx) {
        return new QnAResponseDto(qnaRepository.findById(idx).orElseThrow());
    }

    @Transactional(readOnly = true)
    public boolean existsByIdAndQnaPw(long qnaIdx, String qnaPw) {
        return qnaRepository.existsByQnaIdxAndQnaPw(qnaIdx, qnaPw);
    }
}