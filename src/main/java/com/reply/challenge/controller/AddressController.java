package com.reply.challenge.controller;

import com.reply.challenge.model.Address;
import com.reply.challenge.model.Customer;
import com.reply.challenge.service.AddressService;
import com.reply.challenge.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/v1/addresses")
public class AddressController {
    private final AddressService addressService;
    private final CustomerService customerService;

    @Autowired
    public AddressController(AddressService addressService, CustomerService customerService) {
        this.addressService = addressService;
        this.customerService = customerService;
    }

    @GetMapping
    public ResponseEntity<List<Address>> getAddress() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(addressService.getAllAddresses());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Address> getAddressById(@PathVariable int id) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(addressService.getAddressById(id));
    }

    @PostMapping("/addToCustomer/{id}")
    public ResponseEntity<Address> addAddressToCustomer(
            @PathVariable int id,
            @RequestBody Address address) {

        Customer customer = customerService.getCustomerById(id);
        if (customer == null) {
            return ResponseEntity.notFound().build();
        }

        address.setCustomer(customer);

        addressService.addAddress(address);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(address.getId())
                .toUri();
        return ResponseEntity
                .created(location)
                .body(address);

    }

}