package com.practice.Sandbox.entity;

import com.practice.Sandbox.entity.constants.OrderStatus;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@RequiredArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "orders")
public class Order {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long id;

  @NotBlank(message = "customer name cannot be blank")
  @NonNull
  @Column(name = "customer_name")
  private String customerName;

  @NotNull(message = "order date cannot be null")
  @NonNull
  @Column(name = "order_date")
  private LocalDateTime orderDate;

  @NotNull(message = "order status cannot be blank")
  @NonNull
  @Column(name = "order_status")
  @Enumerated(EnumType.STRING)
  private OrderStatus orderStatus;

  @NotNull(message = "total cannot be null")
  @NonNull
  @Column(name = "total")
  private BigDecimal total;
}
