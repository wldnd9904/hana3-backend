package com.study.ex03_autowired;

import org.springframework.stereotype.Component;

@Component
public class Member {
    private String name;
    private ICard iCard;

    //기본생성자
    public Member() {
    }

    //매개변수있는 생성자
    public Member(String name, ICard iCard) {
        this.iCard = iCard;
        this.name = name;
    }
    //getter/setter

    public String getName() {
        return name;
    }

    public ICard getiCard() {
        return iCard;
    }

    public void setiCard(ICard iCard) {
        this.iCard = iCard;
    }

    public void setName(String name) {
        this.name = name;
    }
}
