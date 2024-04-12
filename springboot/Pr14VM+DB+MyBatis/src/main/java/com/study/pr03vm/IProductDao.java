package com.study.pr03vm;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper
public interface IProductDao {
    int count();

    List<ProductDto> list();

    int insert(ProductDto dto);

    int deleteById(long id);

    int update(ProductDto dto);

    Optional<ProductDto> findById(long id);
}
