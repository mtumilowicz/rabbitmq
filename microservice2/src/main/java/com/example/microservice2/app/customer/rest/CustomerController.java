package com.example.microservice2.app.customer.rest;

import com.example.microservice2.domain.customer.model.Customer;
import com.example.microservice2.domain.customer.service.CustomerService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by mtumilowicz on 2018-07-20.
 */
@RestController
@AllArgsConstructor
@RequestMapping("customers")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class CustomerController {

    CustomerService service;
    
    @GetMapping()
    public List<Customer> findAll() {
        return service.findAll();
    }

    @GetMapping("health")
    public void health() {
        
    }
}
