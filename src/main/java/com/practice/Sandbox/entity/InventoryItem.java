package com.practice.Sandbox.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@RequiredArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "inventory_item")
public class InventoryItem {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long id;

  @NotBlank(message = "name cannot be blank")
  @NonNull
  @Column(name = "name")
  private String name;

  @NotBlank(message = "quantity cannot be blank")
  @NonNull
  @Column(name = "quantity")
  private int quantity;

  @NotBlank(message = "unit price cannot be blank")
  @NonNull
  @Column(name = "unitPrice")
  private BigDecimal unitPrice;

  @NotBlank(message = "category cannot be blank")
  @NonNull
  @Column(name = "category")
  private String category;

  @UpdateTimestamp
  @Column(name = "updated_at")
  private LocalDateTime updatedAt;
}
