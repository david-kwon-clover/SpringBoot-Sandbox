package com.practice.Sandbox.service;

import com.practice.Sandbox.entity.User;

public interface UserService {
  void saveUser(User user);
  User getUserByUsername(String username);
  User getUserById(Long id);
}
