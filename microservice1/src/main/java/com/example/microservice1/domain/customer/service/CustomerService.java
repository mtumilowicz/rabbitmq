package com.example.microservice1.domain.customer.service;

import com.example.microservice1.infrastructure.customer.CustomerRepository;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

/**
 * Created by mtumilowicz on 2018-07-18.
 */
@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@AllArgsConstructor
public class CustomerService {
    CustomerRepository repository;
    
    
}
