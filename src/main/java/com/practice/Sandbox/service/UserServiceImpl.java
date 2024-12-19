package com.practice.Sandbox.service;

import com.practice.Sandbox.entity.User;
import com.practice.Sandbox.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

  UserRepository userRepository;
  BCryptPasswordEncoder bCryptPasswordEncoder;

  @Override
  public void saveUser(User user) {
    user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
    userRepository.save(user);
  }

  @Override
  public User getUserByUsername(String username) {
    Optional<User> user = userRepository.findByUsername(username);

  }

  static User unwrapUser(Optional<User> entity, Long id) {
    if(entity.isPresent()) {
      return entity.get();
    } else {

    }
  }
}
