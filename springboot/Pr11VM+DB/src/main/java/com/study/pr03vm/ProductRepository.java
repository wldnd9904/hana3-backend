package com.study.pr03vm;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Long> {
    @Modifying
    @Transactional
    @Query("UPDATE ProductEntity p SET p.name = :name, p.price = :price, p.limitDate = :limitDate WHERE p.id = :id")
    void updateProduct(Long id, String name, int price, LocalDate limitDate);
}