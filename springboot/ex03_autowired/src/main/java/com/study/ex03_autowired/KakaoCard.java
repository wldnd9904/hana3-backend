package com.study.ex03_autowired;

import org.springframework.stereotype.Component;

@Component("kakaoCard")
public class KakaoCard implements ICard {
    @Override
    public void buy(String itemName) {
        System.out.println("카카오 카드로 " + itemName + "을 샀다.");
    }
}
