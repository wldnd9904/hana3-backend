package com.study.exam01.domain.customer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface One2OneRepository extends JpaRepository<One2One, Long> {

}