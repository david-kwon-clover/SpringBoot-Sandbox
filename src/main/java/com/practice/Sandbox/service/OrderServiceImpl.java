package com.practice.Sandbox.service;

import com.practice.Sandbox.repository.OrderRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class OrderServiceImpl implements OrderService {
  private final OrderRepository orderRepository;
}
