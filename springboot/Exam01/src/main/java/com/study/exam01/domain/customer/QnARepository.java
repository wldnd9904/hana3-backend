package com.study.exam01.domain.customer;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QnARepository extends JpaRepository<QnA, Long> {

    Page<QnA> findAllByOrderByQnaDateDescQnaIdxDesc(Pageable pageable);

    Page<QnA> findAllByQnaTitleContainingOrderByQnaDateDescQnaIdxDesc(Pageable pageable, String title);

    Page<QnA> findAllByQnaContentContainingOrderByQnaDateDescQnaIdxDesc(Pageable pageable, String content);

    Page<QnA> findAllByQnaNameContainingOrderByQnaDateDescQnaIdxDesc(Pageable pageable, String name);

    boolean existsByQnaIdxAndQnaPw(long qnaIdx, String qnaPw);
}
