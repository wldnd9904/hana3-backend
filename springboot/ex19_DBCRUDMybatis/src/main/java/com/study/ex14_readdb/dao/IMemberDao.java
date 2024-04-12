package com.study.ex14_readdb.dao;

import com.study.ex14_readdb.dto.MemberDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Optional;

//@Mapper: 인터페이스 DAO와 MyBatis XML과 연결
@Mapper
public interface IMemberDao {
    List<MemberDto> list();

    int count();

    int insert(MemberDto dto);

    int deleteById(long id);

    int update(MemberDto dto);

    Optional<MemberDto> getById(long id);


}
