package com.practice.Sandbox.service;

import com.practice.Sandbox.entity.MenuItem;
import com.practice.Sandbox.exception.EntityNotFoundException;
import com.practice.Sandbox.repository.MenuItemRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class MenuItemServiceImpl implements MenuItemService {

  private MenuItemRepository menuItemRepository;

  @Override
  public MenuItem getMenuItem(Long id) {
    Optional<MenuItem> menuItem = menuItemRepository.findById(id);
    return unwrapMenuItem(menuItem, id);
  }

  @Override
  public List<MenuItem> getAllMenuItems() {
    return (List<MenuItem>) menuItemRepository.findAll();
  }

  @Override
  public MenuItem saveMenuItem(MenuItem menuItem) {
    return menuItemRepository.save(menuItem);
  }

  @Override
  public MenuItem updateMenuItem(Long id, MenuItem menuItem) {
    return menuItemRepository.findById(id)
        .map(existingItem -> {
          existingItem.setName(menuItem.getName());
          existingItem.setImageUrl(menuItem.getImageUrl());
          existingItem.setDescription(menuItem.getDescription());
          existingItem.setPrice(menuItem.getPrice());
          existingItem.setCategory(menuItem.getCategory());
          existingItem.setAvailable(menuItem.getAvailable());
          return menuItemRepository.save(existingItem);
        })
        .orElseThrow(() -> new EntityNotFoundException(id, MenuItem.class));
  }

  @Override
  public void deleteMenuItem(Long id) {
    menuItemRepository.deleteById(id);
  }

  static MenuItem unwrapMenuItem(Optional<MenuItem> entity, Long id) {
    if (entity.isPresent()) {
      return entity.get();
    } else {
      throw new EntityNotFoundException(id, MenuItem.class);
    }
  }
}
