package com.study.ex27_security_01;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SecurityService implements UserDetailsService {
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(UserRole.ADMIN.getValue()));
        return new User("hong", "$2a$12$2qgxkIdKJkAC8iZ2qtPpTOAq7A1XCsDj/FRWfhy7axxecDwXsX1DC", authorities);
    }
    // 사용자 아이디를 통해 사용자 정보와 권한을 스프링 시큐리티에 전달

}
