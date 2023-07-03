package com.reply.challenge.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "productgen")
    @SequenceGenerator(name = "productgen", sequenceName = "product_id_seq", allocationSize = 1)
    private int id;
    private Double price;
    private String name;
    private Integer amountInStock;
    @ManyToMany(mappedBy = "products")
    private List<PurchaseOrder> orders;
    @Enumerated(EnumType.STRING)
    private Category category;
    public Product() {
        super();
    }
    public Product(Double price, String name, Integer amountInStock, Category category) {
        this.price = price;
        this.name = name;
        this.amountInStock = amountInStock;
        this.category = category;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAmountInStock() {
        return amountInStock;
    }

    public void setAmountInStock(Integer amountInStock) {
        this.amountInStock = amountInStock;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

}
