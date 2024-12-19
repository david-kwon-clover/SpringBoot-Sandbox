package com.practice.Sandbox.repository;

import com.practice.Sandbox.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
}
