package com.practice.Sandbox.repository;

import com.practice.Sandbox.entity.InventoryItem;
import jakarta.transaction.Transactional;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface InventoryItemRepository extends CrudRepository<InventoryItem, Integer> {
  Optional<InventoryItem> findById(Long id);
  @Transactional
  void deleteById(Long id);
}
