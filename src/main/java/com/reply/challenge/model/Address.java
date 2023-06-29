package com.reply.challenge.model;


import jakarta.persistence.*;

@Entity
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "addressgen")
    @SequenceGenerator(name = "addressgen", sequenceName = "address_id_seq", allocationSize = 1)
    private int id;

    private String city;

    private String country;

    @Enumerated(EnumType.STRING)
    private Type type;

    @OneToOne(mappedBy = "address")
    private Customer customer;

    public Address() {
        super();
    }

    public Address(String city, String country, Type type, Customer customer) {
        this.city = city;
        this.country = country;
        this.type = type;
        this.customer = customer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
