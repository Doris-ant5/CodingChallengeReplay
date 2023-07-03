package com.reply.challenge.repository;

import com.reply.challenge.model.AccountType;
import com.reply.challenge.model.Customer;
import com.reply.challenge.model.Product;
import com.reply.challenge.model.ProfileType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    Optional<Customer> findCustomerByName (String name);

    List<Customer> findCustomerByProfileTypeAndAccountType (ProfileType profileType, AccountType accountType);

}
