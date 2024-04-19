package com.study.exam01.domain.customer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface One2OneReplyRepository extends JpaRepository<One2OneReply, Long> {

}