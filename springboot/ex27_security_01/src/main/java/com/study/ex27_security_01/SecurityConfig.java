package com.study.ex27_security_01;

import jakarta.servlet.http.HttpServlet;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity // 웹보안 활성화 위한 어노테이션
public class SecurityConfig {
    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests((auth) -> auth
                //루트 밑의 모든 경로에 대한 모든 요청 허가
                .requestMatchers(new AntPathRequestMatcher("/**"))
                .permitAll()
        ).formLogin((formLogin) -> formLogin
                //로그인 페이지를 /loginForm URI로 하겠다
                .loginPage("/loginForm")
                //로그인 액션은 /loginAction URI
                .loginProcessingUrl("/loginAction")
                //로그인되면 여기로 넘어가라
                .defaultSuccessUrl("/")
                //모든 사용자에게 허용
                .permitAll()
        );
        return http.build();
    }
}
