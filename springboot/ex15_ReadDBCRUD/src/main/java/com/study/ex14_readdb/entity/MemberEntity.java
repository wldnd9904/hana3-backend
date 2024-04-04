package com.study.ex14_readdb.entity;

import com.study.ex14_readdb.dto.MemberSaveDto;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Entity
@Table(name = "member")
@Getter
@AllArgsConstructor
@NoArgsConstructor // @ModelAttribute @RequestBody ㅁㅐ핑시 필요
public class MemberEntity {
    @Id
    @Column
    private Long id;
    @Column(name = "user_id")
    private String userId;
    @Column(name = "user_pw")
    private String userPw;
    @Column(name = "user_name")
    private String userName;
    @Column(name = "user_role")
    private String userRole;
    @Column(name = "join_date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate joinDate;
//
//    private String userAddress;

    public MemberSaveDto toSaveDto() {
        return new MemberSaveDto(userId, userPw, userName, userRole, joinDate, "");
    }
}
