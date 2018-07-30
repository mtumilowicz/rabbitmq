package com.example.microservice2.infrastructure.rabbitmq.listener.handler;

import com.example.microservice2.domain.customer.service.CustomerService;
import com.example.microservice2.infrastructure.rabbitmq.event.CustomerCreate;
import com.example.microservice2.infrastructure.rabbitmq.event.CustomerDelete;
import com.example.microservice2.infrastructure.rabbitmq.listener.assembler.CustomerCreateAssembler;
import com.example.microservice2.infrastructure.rabbitmq.listener.assembler.CustomerDeleteAssembler;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Component;

/**
 * Created by mtumilowicz on 2018-07-30.
 */
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@AllArgsConstructor
@Component
public class CustomerMessageHandler {
    CustomerService customerService;

    public void processCreate(@NonNull CustomerCreate customer) {
        customerService.save(CustomerCreateAssembler.toEntity(customer));
    }

    public void processDelete(@NonNull CustomerDelete customerDelete) {
        customerService.deleteById(CustomerDeleteAssembler.id(customerDelete));
    }
}
