package com.reply.challenge.service;

import com.reply.challenge.exception.*;
import com.reply.challenge.model.AccountType;
import com.reply.challenge.model.Customer;
import com.reply.challenge.model.ProfileType;
import com.reply.challenge.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {
    private final CustomerRepository customerRepo;
    public CustomerService(CustomerRepository customerRepo) {
        super();
        this.customerRepo = customerRepo;
    }

    public List<Customer> getAllCustomers() {
        return customerRepo.findAll();
    }

    public Customer getCustomerById(int id) {
        Optional<Customer> customerOptional = customerRepo.findById(id);
        if (customerOptional.isEmpty()) {
            throw new CustomerResourceNotFoundException(getNotFoundCustomerIdErrorMessage(id));
        }
        return customerOptional.get();
    }

    public Customer searchCustomerByName (String name) {
        Optional<Customer> customerOptional = customerRepo.findCustomerByName(name);
        if(customerOptional.isEmpty()) {
            throw new CustomerResourceNotFoundException(getNotFoundNameErrorMessage(name));
        }
        return customerOptional.get();
    }

    public List<Customer> searchCustomerByProfileTypeAndAccountType(ProfileType profileType, AccountType accountType) {
        List<Customer> customers = customerRepo.findCustomerByProfileTypeAndAccountType(profileType, accountType);
        if (customers.isEmpty()) {
            throw new CustomerResourceNotFoundException(getNotFoundCustomerErrorMessage(profileType.toString() + accountType.toString()));
        }
        return customers;
    }

    private void validateTaxNumberForCompanyAccount(Customer customer) {
        if (customer.getAccountType() == AccountType.COMPANY && (customer.getTaxNumber() == null || customer.getTaxNumber().isEmpty())) {
            throw new EmptyTaxNumberException("Tax number is required for company accounts.");
        }
    }

    public Customer addCustomer(Customer customer) {
        Optional<Customer> customerOptional = customerRepo.findCustomerByName(customer.getName());
        if (customerOptional.isPresent()) {
            throw new CustomerNameExistsException("Customer with name of " + customer.getName() + " already exists.");
        }
        validateTaxNumberForCompanyAccount(customer); // Calling the assistant method

        return customerRepo.save(customer);
    }

    public void deleteCustomerById(int id) {
        Optional<Customer> customerOptional = customerRepo.findById(id);
        if (customerOptional.isEmpty()) {
            throw new CustomerResourceNotFoundException(getNotFoundCustomerIdErrorMessage(id));
        }
        customerRepo.deleteById(id);
    }

    private void validateProfileType(String profileType) {
        try {
            ProfileType.valueOf(profileType); // Check value in ENUM class
        } catch (IllegalArgumentException e) {
            throw new InvalidProfileTypeException("Invalid profile type. Allowed values: STANDARD, GOLD, PREMIUM, EXTRA_PREMIUM");
        }
    }

    public Customer updateCustomerById (Customer customer, int id) {
        Optional<Customer> customerOptional = customerRepo.findById(id);
        if (customerOptional.isEmpty()) {
            throw new CustomerResourceNotFoundException(getNotFoundCustomerIdErrorMessage(id));
        }
        validateTaxNumberForCompanyAccount(customer); // Calling the assistant method
        validateProfileType(customer.getProfileType().name());

        customer.setId(id);
        return customerRepo.save(customer);
    }

    private String getNotFoundNameErrorMessage(String name) {
        return "Customer with name " + name + " not found.";
    }

    private String getNotFoundCustomerIdErrorMessage(int id) {
        return "Customer with id " + id + " not found.";
    }

    private String getNotFoundCustomerErrorMessage(String s) {
        return "Customer/s not found.";
    }

}