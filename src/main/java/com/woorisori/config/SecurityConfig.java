package com.woorisori.config;

import com.woorisori.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@RequiredArgsConstructor
public class SecurityConfig {

    private final MemberRepository memberRepository;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

    @Bean
    SecurityFilterChain filter(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/", "/members/**", "/fragments/**", "/api/checkEmpNo", "/css/**", "/js/**", "/img/**").permitAll()
                        .anyRequest().authenticated()
                )
                .formLogin(login -> login
                        .loginPage("/members/login").permitAll()
                        .loginProcessingUrl("/members/login")
                        .usernameParameter("empNo")
                        .passwordParameter("password")
                        .defaultSuccessUrl("/",true)
                )
                .logout(l -> l.logoutUrl("/members/logout").logoutSuccessUrl("/"));
        return http.build();

    }

    @Bean
    UserDetailsService userDetailsService() {
        return username -> memberRepository.findByEmpNo(username)
                .map(m -> User.withUsername(m.getEmpNo())
                        .password(m.getPassword())
                        .build())
                .orElseThrow(()->new UsernameNotFoundException("없는 사용자: " + username));
    }


}
