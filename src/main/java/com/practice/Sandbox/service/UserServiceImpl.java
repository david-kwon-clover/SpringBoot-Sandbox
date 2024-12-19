package com.practice.Sandbox.service;

import com.practice.Sandbox.entity.User;
import com.practice.Sandbox.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

  UserRepository userRepository;

  @Override
  public void saveUser(User user) {
    userRepository.save(user);
  }
}
