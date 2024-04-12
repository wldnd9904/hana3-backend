package com.study.ex14_readdb.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

public record MemberDto(
        Long id,
        String userId,
        String userPw,
        String userName,
        String userRole,
        @DateTimeFormat(pattern = "yyyy-MM-dd")
        LocalDate joinDate
) {
}

//@Getter
//@Setter
//public class MemberDto {
//    private Long id;
//    private String userId;
//    private String userPw;
//    private String userName;
//    private String userRole;
//    @DateTimeFormat(pattern = "yyyy-MM-dd")
//    private LocalDate joinDate;
//}
