package com.example.microservice2.infrastructure.repository;

import com.example.microservice2.domain.customer.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by mtumilowicz on 2018-07-18.
 */
@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
}
