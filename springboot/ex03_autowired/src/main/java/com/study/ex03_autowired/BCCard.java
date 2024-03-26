package com.study.ex03_autowired;

import org.springframework.stereotype.Component;

@Component("cardBC")//빈의 이름을 직접 지정
public class BCCard implements ICard {
    @Override
    public void buy(String itemName) {
        System.out.println("BC카드로 " + itemName + "을 샀다.");
    }
}
