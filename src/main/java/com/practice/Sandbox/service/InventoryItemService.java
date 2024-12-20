package com.practice.Sandbox.service;

import com.practice.Sandbox.entity.InventoryItem;

import java.util.List;
import java.util.Optional;

public interface InventoryItemService {
  InventoryItem getInventoryItemById(Long id);
  List<InventoryItem> getInventoryItems();
  InventoryItem saveInventoryItem(InventoryItem inventoryItem);
}
