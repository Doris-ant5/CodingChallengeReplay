package com.reply.challenge.service;

import com.reply.challenge.exception.AddressResourceNotFoundException;
import com.reply.challenge.exception.CustomerResourceNotFoundException;
import com.reply.challenge.exception.ProductNameExistsException;
import com.reply.challenge.model.Address;
import com.reply.challenge.model.Customer;
import com.reply.challenge.model.Product;
import com.reply.challenge.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddressService {
    private final AddressRepository addressRepo;
    private final CustomerService customerService;

    @Autowired
    public AddressService(AddressRepository addressRepo, CustomerService customerService) {
        this.addressRepo = addressRepo;
        this.customerService = customerService;
    }

    public List<Address> getAllAddresses() {
        return addressRepo.findAll();
    }

    public Address getAddressById(int id) {
        Optional<Address> addressOptional = addressRepo.findById(id);
        if (addressOptional.isEmpty()) {
            throw new AddressResourceNotFoundException(getNotFoundAddressIdErrorMessage(id));
        }
        return addressOptional.get();
    }

    public Address addAddress(Address address) {
        return addressRepo.save(address);
    }

/*    public Address addAddressToCustomer(int id, Address address) {
        Customer customer = customerService.getCustomerById(id);
        if (customer == null) {
            throw new CustomerResourceNotFoundException("Customer with id " + id + " does noty exist.");
        }

        address.setCustomer(customer);
        Address savedAddress = addressRepo.addAddressToCustomer(id, address);
        return savedAddress;
    }*/


    private String getNotFoundAddressIdErrorMessage(int id) {
        return "Address with id " + id + " not found.";
    }

}
