package com.reply.challenge.controller;

import com.reply.challenge.model.Address;
import com.reply.challenge.model.Customer;
import com.reply.challenge.service.AddressService;
import com.reply.challenge.service.CustomerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.headers.Header;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
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

    @Operation(
            summary = "Retrieving all addresses resources",
            method = "GET",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Json list of addresses resources in body of response.",
                            content = {@Content(mediaType = "application/json")}
                    )
            }
    )

    @GetMapping
    public ResponseEntity<List<Address>> getAddress() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(addressService.getAllAddresses());
    }

    @Operation(
            summary = "Finds and returns a single address resource by the supplied id.",
            method = "GET",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Address resource successfully found and returned as json object in."
                                    + " Body of the response.",
                            content = {@Content(mediaType = "application/json")}
                    ),
                    @ApiResponse(
                            responseCode = "404",
                            description = "Addresses resource not found.",
                            content = {@Content(mediaType = "text/plain")}
                    )
            }
    )

    @GetMapping("/{id}")
    public ResponseEntity<Address> getAddressById(@PathVariable int id) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(addressService.getAddressById(id));
    }

    @Operation(
            summary = "Add new addresss resource to existing customer by indicating the consumer ID.",
            description = "Accepts and validates a customer object passed via body of the request. Checks that the ID  "
                    + " Checks if the customer object with the specified ID is not found. If the customer with the specified ID " +
                    " does not exist, it creates a response of type ResponseEntity with the HTTP response code 404 Not Found.",
            method = "POST",
            responses = {
                    @ApiResponse(
                            responseCode = "201",
                            description = "Address added to specified customer.",
                            content = {@Content(mediaType = "application/json")},
                            headers = {@Header(
                                    name = "Location",
                                    description = "URI of address resource with an assigned existing customer."
                            )}
                    ),
                    @ApiResponse(
                            responseCode = "404",
                            description = "Customer with specified ID and addresses resource not found.",
                            content = {@Content(mediaType = "text/plain")}
                    )
            }
    )

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