package com.study.ex02_springdi;

import org.springframework.stereotype.Component;

// 빈 생성 시 POJO(Plain Old Java Class) 클래스 이용
// POJO: EJB와 달리 순수한 자바 클래스, getter/setter/생성자만 추가
@Component
public class Member {
    private String name = "이순신";

    //Default Initializer
    public Member() {
    }

    //Initializer w/ Args
    public Member(String name) {
        this.name = name;
    }

    //Getter/Setter
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
