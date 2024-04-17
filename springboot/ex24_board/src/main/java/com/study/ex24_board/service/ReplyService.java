package com.study.ex24_board.service;

import com.study.ex24_board.domain.reply.Reply;
import com.study.ex24_board.domain.reply.ReplyRepository;
import com.study.ex24_board.dto.ReplyResponseDto;
import com.study.ex24_board.dto.ReplySaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReplyService {
    private final ReplyRepository replyRepository;

    public List<ReplyResponseDto> findAll() { //전체 목록 조회
        Sort sort = Sort.by(Sort.Direction.DESC, "replyDate", "replyIdx");
        List<Reply> list = replyRepository.findAll(sort);
        return list.stream().map(ReplyResponseDto::new).toList();
    }

    @Transactional
    public ReplyResponseDto findById(long id) {
        Reply entity = replyRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("없는 id 입니다. id:" + id));
        return new ReplyResponseDto(entity);
    }

    @Transactional
    public Long save(final ReplySaveRequestDto dto) {
        Reply entity = replyRepository.save(dto.toEntity());
        return entity.getReplyIdx();
    }

    @Transactional
    public Long save(final Reply reply) {
        Reply entity = replyRepository.save(reply);
        return entity.getReplyIdx();
    }

    @Transactional(readOnly = true)
    public boolean existById(long idx) {
        return replyRepository.existsById(idx);
    }

    @Transactional
    public boolean deleteById(long id) {
        replyRepository.deleteById(id);
        return !replyRepository.existsById(id);
    }

    @Transactional
    public Reply update(final Long replyIdx, final ReplySaveRequestDto dto) {
        Reply entity = replyRepository.findById(replyIdx)
                .orElseThrow(() -> new IllegalArgumentException(
                        "없는 댓글입니다. replyIdx:" + replyIdx));
        entity.update(dto.replyName(), dto.replyContent());
        return entity;
    }
}
