package com.practice.Sandbox.repository;

import com.practice.Sandbox.entity.MenuItem;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface MenuItemRepository extends CrudRepository<MenuItem, Long> {
  Optional<MenuItem> findById(Long id);
}
