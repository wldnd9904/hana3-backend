package com.study.pr10memberadminapi.response;

public record AlertResponse(String message, String status) {
    public AlertResponse(String message, String status) {
        this.message = message;
        this.status = status;
        System.out.println(message);
    }
}
