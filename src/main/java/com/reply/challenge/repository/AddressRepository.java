package com.reply.challenge.repository;

import com.reply.challenge.model.Address;
import com.reply.challenge.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AddressRepository extends JpaRepository<Address, Integer> {


}
