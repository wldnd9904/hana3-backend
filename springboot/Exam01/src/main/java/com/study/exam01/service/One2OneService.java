package com.study.exam01.service;

import com.study.exam01.domain.customer.One2One;
import com.study.exam01.domain.customer.One2OneRepository;
import com.study.exam01.dto.customer.One2OneSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class One2OneService {
    private final One2OneRepository one2OneRepository;

    @Transactional
    public boolean save(One2OneSaveRequestDto dto) {
        Long idx = one2OneRepository.save(dto.toEntity()).getOne2OneIdx();
        return one2OneRepository.existsById(idx);
    }
}
