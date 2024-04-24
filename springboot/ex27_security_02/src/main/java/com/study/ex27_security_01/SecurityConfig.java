package com.study.ex27_security_01;

import jakarta.servlet.http.HttpServlet;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity // 웹보안 활성화 위한 어노테이션
public class SecurityConfig {
    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                //기본적으로 csrf(사이트 간 요청 위조) 활성화 되어 있음
                //csrf 보안 비활성화
                //.csrf((auth) -> auth.disable())
                .csrf((auth) -> auth.csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse()))


                //HTTP요청에 대한 보안설정 시작
                .authorizeHttpRequests((auth) -> auth
                        //루트 밑의 모든 경로에 대한 모든 요청 허가
                        .requestMatchers(new AntPathRequestMatcher("/**")).permitAll()
                        .requestMatchers("/admin").hasRole("ADMIN")
                        .requestMatchers("/my/**").hasAnyRole("ADMIN", "USER")
                        .anyRequest().authenticated() // 그 외 요청은 인증한다
                )


                .formLogin((formLogin) -> formLogin
                        //로그인 페이지를 /loginForm URI로 하겠다
                        .loginPage("/loginForm")
                        //로그인 액션은 /loginAction URI
                        .loginProcessingUrl("/loginAction")
                        //로그인되면 여기로 넘어가라
                        .defaultSuccessUrl("/")
                        //모든 사용자에게 허용
                        .successHandler((request, response, authentication) -> {
                            System.out.println("로그인 성공");
                            response.sendRedirect("/");
                        })
                        .permitAll())
                .logout((auth) -> auth
                        .logoutRequestMatcher(new AntPathRequestMatcher("/logoutAction"))
                        .logoutSuccessUrl("/")
                        .invalidateHttpSession(true)
                        .deleteCookies("JSESSIONID")
                );

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        //Spring Security 5.3.3에서 공식 지원하는 PasswordEncoder 구현 클래스들은 아래와 같습니다.
        //BcryptPasswordEncoder : BCrypt 해시 함수를 사용해 비밀번호를 암호화
        //Argon2PasswordEncoder : Argon2 해시 함수를 사용해 비밀번호를 암호화
        //Pbkdf2PasswordEncoder : PBKDF2 해시 함수를 사용해 비밀번호를 암호화
        //SCryptPasswordEncoder : SCrypt 해시 함수를 사용해 비밀번호를 암호화

        //강도는 4~31, default: 10
        return new BCryptPasswordEncoder(16);
        //return SCryptPasswordEncoder.defaultsForSpringSecurity_v5_8();
        //return Argon2PasswordEncoder.defaultsForSpringSecurity_v5_8();
        //return Pbkdf2PasswordEncoder.defaultsForSpringSecurity_v5_8();
    }
}








