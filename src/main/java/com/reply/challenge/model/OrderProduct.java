package com.reply.challenge.model;

import jakarta.persistence.*;

@Entity
@Table(name = "order_product")
public class OrderProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ordersproductgen")
    @SequenceGenerator(name = "ordersproductgen", sequenceName = "orders_product_id_seq", allocationSize = 1)
    private int id;
    @ManyToOne
    @JoinColumn(name = "order_id")
    private PurchaseOrder order;
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;
    private int amount;
    private double priceItem;
    public OrderProduct() {
        super();
    }

    public OrderProduct(PurchaseOrder order, Product product, int amount, double priceItem) {
        this.order = order;
        this.product = product;
        this.amount = amount;
        this.priceItem = priceItem;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public PurchaseOrder getOrder() {
        return order;
    }

    public void setOrder(PurchaseOrder order) {
        this.order = order;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public double getPriceItem() {
        return priceItem;
    }

    public void setPriceItem(double priceItem) {
        this.priceItem = priceItem;
    }

}
