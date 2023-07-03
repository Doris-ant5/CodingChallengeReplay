package com.reply.challenge.controller;

import com.reply.challenge.model.AccountType;
import com.reply.challenge.model.Customer;
import com.reply.challenge.model.ProfileType;
import com.reply.challenge.service.CustomerService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;


@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        super();
        this.customerService = customerService;
    }

    @GetMapping
    public ResponseEntity<List<Customer>> getCustomer() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(customerService.getAllCustomers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable int id) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(customerService.getCustomerById(id));
    }

    @GetMapping("searchCustomerByName/{name}") //localhost:XXXX/api/v1/customers/{name}
    private ResponseEntity<Customer> getCustomerName(@PathVariable String name) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(customerService.searchCustomerByName(name));
    }

    @GetMapping("searchCustomerByProfileTypeAndAccountType")
    private ResponseEntity<List<Customer>> getCustomerProfileAndAccountType(
            @RequestParam("profile") ProfileType profileType,
            @RequestParam("account") AccountType accountType) {
        List<Customer> customers = customerService.searchCustomerByProfileTypeAndAccountType(profileType, accountType);
        if (customers.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(customerService.searchCustomerByProfileTypeAndAccountType(profileType, accountType));
    }



    @PostMapping
    public ResponseEntity<Customer> addCustomer(@Valid @RequestBody Customer customer) {
        customerService.addCustomer(customer);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(customer.getId())
                .toUri();
        return ResponseEntity
                .created(location)
                .body(customer);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Customer> updateCustomer(@Valid @RequestBody Customer customer, @PathVariable int id) {
        return ResponseEntity.ok(customerService.updateCustomerById(customer, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable int id) {
        customerService.deleteCustomerById(id);
        return ResponseEntity
                .status(HttpStatus.OK)
                .build();
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable int id, @RequestBody Customer updatedCustomer) {
        Customer existingCustomer = customerService.getCustomerById(id);
        if (existingCustomer == null) {
            return ResponseEntity.notFound().build();
        }

        if (updatedCustomer.getProfileType() != null) {
            existingCustomer.setProfileType(updatedCustomer.getProfileType());
        }
        if (updatedCustomer.getNumberIdentification() != null) {
            existingCustomer.setNumberIdentification(updatedCustomer.getNumberIdentification());
        }

        return ResponseEntity.ok(customerService.updateCustomerById(existingCustomer, id));
    }

}