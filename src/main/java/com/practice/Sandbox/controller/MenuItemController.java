package com.practice.Sandbox.controller;

import com.practice.Sandbox.entity.MenuItem;
import com.practice.Sandbox.service.MenuItemService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/menu")
@AllArgsConstructor
public class MenuItemController {

  private MenuItemService menuItemService;

  @GetMapping("/{id}")
  public ResponseEntity<MenuItem> getMenuItem(@PathVariable Long id) {
    return new ResponseEntity<>(menuItemService.getMenuItem(id), HttpStatus.OK);
  }

  @GetMapping("/all")
  public ResponseEntity<List<MenuItem>> getAllMenuItems() {
    return new ResponseEntity<>(menuItemService.getAllMenuItems(), HttpStatus.OK);
  }

  @PostMapping
  public ResponseEntity<MenuItem> createMenuItem(@RequestBody MenuItem menuItem) {
    return new ResponseEntity<>(menuItemService.saveMenuItem(menuItem), HttpStatus.CREATED);
  }

  @PutMapping("/{id}")
  public ResponseEntity<MenuItem> updateMenuItem(@PathVariable Long id, @RequestBody MenuItem menuItem) {
    return new ResponseEntity<>(menuItemService.updateMenuItem(id, menuItem), HttpStatus.OK);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<MenuItem> deleteMenuItem(@PathVariable Long id) {
    menuItemService.deleteMenuItem(id);
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }
}
