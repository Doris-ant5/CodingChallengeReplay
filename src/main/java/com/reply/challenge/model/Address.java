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

    private Type type;

    @OneToOne(mappedBy = "address")
    private Customer customer;
}
