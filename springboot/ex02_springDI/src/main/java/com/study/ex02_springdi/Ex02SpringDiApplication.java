package com.study.ex02_springdi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Ex02SpringDiApplication {
    // 빈 생성하는 2가지
    // 1. @Configuration + @Bean
    // 2. @Component + @Autowired
    //  1) 필드 주입: 일반적인 방법
    //  2) 수정자 주입
    //  3) 생성자 주입 : 추천하는 방법
    public static void main(String[] args) {
        
        SpringApplication.run(Ex02SpringDiApplication.class, args);
    }

}
