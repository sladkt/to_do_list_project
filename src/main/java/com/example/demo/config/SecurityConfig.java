package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean // SecurityFilterChain을 Bean으로 등록 (WebSecurityConfigurerAdapter 대체)
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .csrf((csrf) -> csrf.disable()) // CSRF 보호 비활성화 (람다식, Spring Security 6부터 권장)
            .authorizeHttpRequests((authorizeRequests) -> // authorizeRequests -> authorizeHttpRequests (Spring Security 6부터 변경)
                authorizeRequests
                    .requestMatchers("/authenticate", "/register").permitAll() // 로그인, 회원가입은 누구나 접근 가능
                    .requestMatchers(HttpMethod.GET, "/todos/**").hasRole("USER") // GET 요청은 USER 권한만 가능 (ROLE_USER 로 자동 prefix)
                    .anyRequest().authenticated() // 나머지 요청은 인증된 사용자만 접근 가능
            )
            .formLogin((formLogin) -> formLogin.disable()); // 폼 로그인 비활성화 (람다식)

        return http.build(); // SecurityFilterChain 빌드
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}