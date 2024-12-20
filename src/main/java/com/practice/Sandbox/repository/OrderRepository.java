package com.practice.Sandbox.repository;

import com.practice.Sandbox.entity.Order;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<Order, Long> {
}
