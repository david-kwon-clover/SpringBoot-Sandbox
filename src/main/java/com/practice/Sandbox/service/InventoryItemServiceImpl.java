package com.practice.Sandbox.service;

import com.practice.Sandbox.entity.InventoryItem;
import com.practice.Sandbox.exception.EntityNotFoundException;
import com.practice.Sandbox.repository.InventoryItemRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class InventoryItemServiceImpl implements InventoryItemService {

  private InventoryItemRepository inventoryItemRepository;

  @Override
  public InventoryItem getInventoryItemById(Long id) {
    Optional<InventoryItem> inventoryItem = inventoryItemRepository.findById(id);
    return unwrapInventoryItem(inventoryItem, id);
  }

  @Override
  public List<InventoryItem> getInventoryItems() {
    return (List<InventoryItem>) inventoryItemRepository.findAll();
  }

  @Override
  public InventoryItem saveInventoryItem(InventoryItem inventoryItem) {
    return inventoryItemRepository.save(inventoryItem);
  }

  @Override
  public InventoryItem updateInventoryItem(Long id, InventoryItem inventoryItem) {
    return inventoryItemRepository.findById(id)
        .map(existingItem -> {
          existingItem.setName(inventoryItem.getName());
          existingItem.setImageUrl(inventoryItem.getImageUrl());
          existingItem.setQuantity(inventoryItem.getQuantity());
          existingItem.setUnitPrice(inventoryItem.getUnitPrice());
          existingItem.setCategory(inventoryItem.getCategory());
          existingItem.setUpdatedAt(LocalDateTime.now());
          return inventoryItemRepository.save(existingItem);
        })
        .orElseThrow(() -> new EntityNotFoundException(id, InventoryItem.class));
  }

  @Override
  @Transactional
  public void deleteInventoryItem(Long id) {
    inventoryItemRepository.deleteById(id);
  }

  static InventoryItem unwrapInventoryItem(Optional<InventoryItem> entity, Long id) {
    if(entity.isPresent()) {
      return entity.get();
    } else {
      throw new EntityNotFoundException(id, InventoryItem.class);
    }
  }
}
