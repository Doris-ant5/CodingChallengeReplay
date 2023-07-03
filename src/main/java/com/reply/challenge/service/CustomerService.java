package com.reply.challenge.service;

import com.reply.challenge.exception.CustomerNameExistsException;
import com.reply.challenge.exception.CustomerResourceNotFoundException;
import com.reply.challenge.exception.ProductResourceNotFoundException;
import com.reply.challenge.model.AccountType;
import com.reply.challenge.model.Customer;
import com.reply.challenge.model.Product;
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

    private String getNotFoundCustomerErrorMessage(String s) {
        return "Customer not found.";
    }


    public Customer addCustomer(Customer customer) {
        Optional<Customer> customerOptional = customerRepo.findCustomerByName(customer.getName());
        if (customerOptional.isPresent()) {
            throw new CustomerNameExistsException("Customer with name of " + customer.getName() + " already exists.");
        }
        return customerRepo.save(customer);
    }

    public void deleteCustomerById(int id) {
        Optional<Customer> customerOptional = customerRepo.findById(id);
        if (customerOptional.isEmpty()) {
            throw new CustomerResourceNotFoundException(getNotFoundCustomerIdErrorMessage(id));
        }
        customerRepo.deleteById(id);
    }

    public Customer updateCustomerById (Customer customer, int id) {
        Optional<Customer> customerOptional = customerRepo.findById(id);
        if (customerOptional.isEmpty()) {
            throw new CustomerResourceNotFoundException(getNotFoundCustomerIdErrorMessage(id));
        }
        customer.setId(id);
        return customerRepo.save(customer);
    }

    private String getNotFoundNameErrorMessage(String name) {
        return "Customer with name " + name + " not found.";
    }

    private String getNotFoundCustomerIdErrorMessage(int id) {
        return "Customer with id " + id + " not found.";
    }

}