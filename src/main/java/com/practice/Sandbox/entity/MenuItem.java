package com.practice.Sandbox.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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

@RequiredArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "menu_item")
public class MenuItem {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long id;

  @NotBlank(message = "name cannot be blank")
  @NonNull
  @Column(name = "name")
  private String name;

  @NotBlank(message = "name cannot be blank")
  @NonNull
  @Column(name = "img")
  private String imageUrl;

  @NotBlank(message = "name cannot be blank")
  @NonNull
  @Column(name = "description")
  private String description;

  @NotNull(message = "price cannot be null")
  @Column(name = "price")
  private BigDecimal price;

  @NotBlank(message = "category cannot be blank")
  @NonNull
  @Column(name = "category")
  private String category;

  @NotNull(message = "availability cannot be null")
  @Column(name = "available")
  private Boolean available;

}
