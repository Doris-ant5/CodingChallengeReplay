package com.reply.challenge.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "customer_type")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "customergen")
    @SequenceGenerator(name = "customergen", sequenceName = "customer_id_seq", allocationSize = 1)
    private int id;

    private Integer numberIdentification;
    private String profileType;
    private String name;

    private String lastName;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<PurchaseOrder> orders = new ArrayList<>();

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private List <Address> addresses;


    public Customer() {
        super();
    }

    public Customer(Integer numberIdentification, String profileType, String name, String lastName) {
        this.numberIdentification = numberIdentification;
        this.profileType = profileType;
        this.name = name;
        this.lastName = lastName;
    }

    public int getId() {
        return id;
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getNumberIdentification() {
        return numberIdentification;
    }

    public void setNumberIdentification(Integer numberIdentification) {
        this.numberIdentification = numberIdentification;
    }

    public String getProfileType() {
        return profileType;
    }

    public void setProfileType(String profileType) {
        this.profileType = profileType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


   public List<PurchaseOrder> getOrders() {
        return orders;
    }

    public void setOrders(List<PurchaseOrder> orders) {
        this.orders = orders;
    }
}
