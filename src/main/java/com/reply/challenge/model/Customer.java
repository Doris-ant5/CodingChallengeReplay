package com.reply.challenge.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "customergen")
    @SequenceGenerator(name = "customergen", sequenceName = "customer_id_seq", allocationSize = 1)
    private int id;
    private Integer numberIdentification;
    @Enumerated(EnumType.STRING)
    private ProfileType profileType;
    private String name;
    @Temporal(TemporalType.DATE)
    private Date birthDate;
    private String lastName;
    @Enumerated(EnumType.STRING)
    private AccountType accountType;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<PurchaseOrder> orders = new ArrayList<>();

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private List <Address> addresses;


    public Customer() {
        super();
    }

    public Customer(Integer numberIdentification, ProfileType profileType, String name,
                    Date birthDate, String lastName, AccountType accountType,
                    List<PurchaseOrder> orders, List<Address> addresses) {
        this.numberIdentification = numberIdentification;
        this.profileType = profileType;
        this.name = name;
        this.birthDate = birthDate;
        this.lastName = lastName;
        this.accountType = accountType;
        this.orders = orders;
        this.addresses = addresses;
    }

    public int getId() {
        return id;
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

    public ProfileType getProfileType() {
        return profileType;
    }

    public void setProfileType(ProfileType profileType) {
        this.profileType = profileType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }

    public List<PurchaseOrder> getOrders() {
        return orders;
    }

    public void setOrders(List<PurchaseOrder> orders) {
        this.orders = orders;
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }
}
