package com.dnb.customerservice.repo;

import java.util.Optional;


import org.springframework.data.repository.CrudRepository;

import com.dnb.customerservice.dto.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Integer> {

}
