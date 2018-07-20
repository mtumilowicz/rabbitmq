package com.example.microservice2.domain.customer.service;

import com.example.microservice2.domain.customer.model.Customer;
import com.example.microservice2.infrastructure.repository.CustomerRepository;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * Created by mtumilowicz on 2018-07-18.
 */
@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@AllArgsConstructor
public class CustomerService {
    CustomerRepository repository;

    public void save(@NotNull Customer customer) {
        repository.save(customer);
    }

    public List<Customer> findAll() {
        return repository.findAll();
    }
}
