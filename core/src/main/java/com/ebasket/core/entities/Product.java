package com.ebasket.core.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "Products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String description;
    private double price;
    private String pictureUrl;
    private String type;
    private String brand;
    private int quantityInStock;
}
