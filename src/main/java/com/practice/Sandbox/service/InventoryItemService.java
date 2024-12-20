package com.practice.Sandbox.service;

import com.practice.Sandbox.entity.InventoryItem;

import java.util.List;

public interface InventoryItemService {
  InventoryItem getInventoryItemById(Long id);
  List<InventoryItem> getInventoryItems();
  InventoryItem saveInventoryItem(InventoryItem inventoryItem);
  void deleteInventoryItem(Long id);
  InventoryItem updateInventoryItem(Long id, InventoryItem inventoryItem);
}
