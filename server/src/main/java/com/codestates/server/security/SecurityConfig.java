package com.codestates.server.security;

import com.codestates.server.security.jwt.JwtAuthenticationFilter;
import com.codestates.server.security.jwt.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@RequiredArgsConstructor
@EnableWebSecurity
public class SecurityConfig {

    private final JwtTokenProvider jwtTokenProvider;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .headers().frameOptions().sameOrigin()
//                .headers().frameOptions().disable()   //h2-console 사용하려면 위에 것 주석처리하고 이것 사용
                .and()
                .csrf().disable()
                .cors(withDefaults())
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .formLogin().disable()
                .httpBasic().disable()
                .authorizeRequests()
                .antMatchers("/signUp", "/login", "/").permitAll()  //회원가입, 로그인, 홈페이지는 모두 허용
                .antMatchers(HttpMethod.GET, "/questions/**").permitAll() // 질문 조회는 누구나 가능
                .antMatchers(HttpMethod.GET,"/tags/**").permitAll() // 태크 조회 누구나 가능
                .antMatchers(HttpMethod.GET, "/members/**").permitAll() // 멤버 정보 조회 누구나 가능
                .antMatchers("/auth/user").hasRole("USER")
                .antMatchers("/auth/admin", "/members").hasRole("ADMIN")    //관리자 권한만 이곳에 설정
                .anyRequest().hasAnyRole("USER", "ADMIN")   //나머지는 관리자, 유저 모두 접근 가능 & 권한 없으면 접근 불가
//                .anyRequest().permitAll()     //나머지를 설정된 api 외에 모든 접근 허용 버전
                .and()
                .addFilterBefore(new JwtAuthenticationFilter(jwtTokenProvider), UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }
}