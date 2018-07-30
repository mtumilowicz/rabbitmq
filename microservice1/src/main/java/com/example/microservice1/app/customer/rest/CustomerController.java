package com.example.microservice1.app.customer.rest;

import com.example.microservice1.domain.customer.model.Customer;
import com.example.microservice1.domain.customer.service.CustomerService;
import com.example.microservice1.app.customer.rest.asembler.CustomerAssembler;
import com.example.microservice1.app.customer.rest.dto.CustomerDto;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by mtumilowicz on 2018-07-17.
 */
@RestController
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class CustomerController {

    CustomerService service;

    @PostMapping("customers")
    public void save(@RequestBody CustomerDto dto) {
        service.save(CustomerAssembler.toEntity(dto));
    }

    @GetMapping("customers")
    public List<Customer> findAll() {
        return service.findAll();
    }

    @DeleteMapping("customers/{id}")
    public void deleteById(@PathVariable("id") Integer id) {
        service.deleteById(id);
    }

    @GetMapping("customers/health")
    public void health() {

    }
}
