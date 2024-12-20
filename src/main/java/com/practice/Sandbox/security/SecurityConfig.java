package com.practice.Sandbox.security;

import com.practice.Sandbox.security.filter.AuthenticationFilter;
import com.practice.Sandbox.security.filter.ExceptionHandlerFilter;
import com.practice.Sandbox.security.manager.CustomAuthenticationManager;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@AllArgsConstructor
public class SecurityConfig {

  CustomAuthenticationManager customAuthenticationManager;

  @Bean
  public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    AuthenticationFilter authenticationFilter = new AuthenticationFilter(customAuthenticationManager);
    authenticationFilter.setFilterProcessesUrl("/authenticate");
    http
        .csrf(csrf -> csrf.disable())
        .headers((headers) -> headers
            .frameOptions(frameOptions -> frameOptions.disable())
        )
        .authorizeHttpRequests((authorize) -> authorize
            .requestMatchers("/h2/**").permitAll()
            .requestMatchers("/user/signup").permitAll()
            .anyRequest().authenticated()
        )
        .addFilterBefore(new ExceptionHandlerFilter(), AuthenticationFilter.class)
        .addFilter(authenticationFilter)
        .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
    return http.build();
  }
}
