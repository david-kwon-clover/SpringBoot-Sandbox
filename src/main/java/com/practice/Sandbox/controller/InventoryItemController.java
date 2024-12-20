package com.practice.Sandbox.controller;

import com.practice.Sandbox.entity.InventoryItem;
import com.practice.Sandbox.service.InventoryItemService;
import com.practice.Sandbox.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/inventory")
@AllArgsConstructor
public class InventoryItemController {

  InventoryItemService inventoryItemService;

  // get by id
  @GetMapping("/{id}")
  public ResponseEntity<InventoryItem> getInventoryItem(@PathVariable Long id) {
    return new ResponseEntity<>(inventoryItemService.getInventoryItemById(id), HttpStatus.OK);
  }

  // get all
  @GetMapping("/all")
  public ResponseEntity<List<InventoryItem>> getAllInventoryItems() {
    return new ResponseEntity<>(inventoryItemService.getInventoryItems(), HttpStatus.OK);
  }

  // post


  // update by id

  // delete
}
