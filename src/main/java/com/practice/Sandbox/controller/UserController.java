package com.practice.Sandbox.controller;

import com.practice.Sandbox.entity.User;
import com.practice.Sandbox.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/user")
public class UserController {

  private UserService userService;

  @PostMapping("/signup")
  public ResponseEntity<User> signup(@RequestBody User user) {

  }
}
