package com.woorisori.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class WebSecurity {

    @Bean
    SecurityFilterChain filter(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/", "/members/**", "/fragments/**", "/api/checkEmpNo", "/css/**", "/js/**", "/img/**").permitAll()
                        .anyRequest().authenticated()
        )
                .formLogin(login -> login.loginPage("/members/login").permitAll()
                        .loginProcessingUrl("/members/login")
                        .defaultSuccessUrl("/",true)
                )
                .logout(l -> l.logoutUrl("/members/logout").logoutSuccessUrl("/"));
        return http.build();

    }
}
