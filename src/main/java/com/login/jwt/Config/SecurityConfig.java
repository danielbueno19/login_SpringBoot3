package com.login.jwt.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

import lombok.RequiredArgsConstructor;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {
    
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
         http
               .csrf(csrf -> csrf.disable())
               .authorizeRequests(authorizeRequests ->
                authorizeRequests
                 .antMatchers("/auth/**").permitAll()
                 .anyRequest().authenticated()
             )
             .formLogin(formLogin -> formLogin
             .loginPage("/login") // Página de inicio de sesión personalizada si es necesario
             .permitAll()
            );
            return http.build();
    }
}
