package com.practice.Sandbox.service;

import com.practice.Sandbox.entity.MenuItem;

import java.util.List;

public interface MenuItemService {
  MenuItem getMenuItem(Long id);
  List<MenuItem> getAllMenuItems();
  MenuItem saveMenuItem(MenuItem menuItem);
  MenuItem updateMenuItem(Long id, MenuItem menuItem);
  void deleteMenuItem(Long id);
}
