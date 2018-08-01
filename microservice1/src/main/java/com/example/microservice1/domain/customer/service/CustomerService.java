package com.example.microservice1.domain.customer.service;

import com.example.microservice1.domain.customer.model.Customer;
import com.example.microservice1.infrastructure.rabbitmq.event.customer.assembler.CustomerDeleteMessageAssembler;
import com.example.microservice1.infrastructure.rabbitmq.event.customer.assembler.CustomerSaveMessageAssembler;
import com.example.microservice1.infrastructure.rabbitmq.publisher.customer.CustomerMessagePublisher;
import com.example.microservice1.infrastructure.repository.CustomerRepository;
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
    CustomerMessagePublisher customerPublisher;

    public void save(@NotNull Customer customer) {
        Customer saved = repository.save(customer);

        customerPublisher.publishSave(CustomerSaveMessageAssembler.toMessage(saved));
    }

    public void deleteById(@NotNull Integer id) {
        repository.deleteById(id);
        customerPublisher.publishDelete(CustomerDeleteMessageAssembler.toMessage(id));
    }

    public List<Customer> findAll() {
        return repository.findAll();
    }
}
