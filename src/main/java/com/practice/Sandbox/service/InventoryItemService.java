package com.practice.Sandbox.service;

import com.practice.Sandbox.entity.InventoryItem;

import java.util.Optional;

public interface InventoryItemService {
  InventoryItem getInventoryItemById(Long id);
}
