package com.study.ex22_tdd;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ResultDto {
    String status;
    String message;
}
