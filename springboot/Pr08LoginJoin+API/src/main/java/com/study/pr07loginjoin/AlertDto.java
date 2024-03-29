package com.study.pr07loginjoin;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AlertDto {
    private String message;
    private String status;
}
