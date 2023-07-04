package com.reply.challenge.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "addressgen")
    @SequenceGenerator(name = "addressgen", sequenceName = "address_id_seq", allocationSize = 1)
    private int id;
    @NotBlank(message = "City must not be null or blank.")
    @Size(min = 1, max= 50, message = "City must be longer than 1 character and less than 50.")
    private String city;
    @NotBlank(message = "Country must not be null or blank.")
    @Size(min = 1, max= 50, message = "Country must be longer than 1 character and less than 50.")
    private String country;
    @Enumerated(EnumType.STRING)
    private AddressType addressType;
    @ManyToOne
    @JoinColumn(name = "customer_id")
    @JsonIgnore
    private Customer customer;
    public Address() {
        super();
    }
    public Address(String city, String country, AddressType addressType, Customer customer) {
        this.city = city;
        this.country = country;
        this.addressType = addressType;
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

    public AddressType getAddressType() {
        return addressType;
    }

    public void setAddressType(AddressType addressType) {
        this.addressType = addressType;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

}
