package com.practice.Sandbox.security.filter;

import com.auth0.jwt.algorithms.Algorithm;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.practice.Sandbox.entity.User;
import com.practice.Sandbox.security.SecurityConstants;
import com.practice.Sandbox.security.manager.CustomAuthenticationManager;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import com.auth0.jwt.JWT;
import java.io.IOException;


@AllArgsConstructor
public class AuthenticationFilter extends UsernamePasswordAuthenticationFilter {

  private CustomAuthenticationManager customAuthenticationManager;

  @Override
  public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
    try {
      User user = new ObjectMapper().readValue(request.getInputStream(), User.class);
      Authentication authentication = new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword());
      return customAuthenticationManager.authenticate(authentication);
    } catch (IOException e) {
      throw new RuntimeException();
    }
  }

  @Override
  protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {
    String token = JWT.create()
        .withSubject(authResult.getName())
        .withExpiresAt(new Date(System.currentTimeMillis() + SecurityConstants.TOKEN_EXPIRATION))
        .sign(Algorithm.HMAC512(SecurityConstants.SECRET_KEY));
    response.addHeader(SecurityConstants.AUTHORIZATION, SecurityConstants.BEARER + token);
  }
}
