package com.example.microservice2.infrastructure.rabbitmq.listener.handler;

import com.example.microservice2.domain.customer.service.CustomerService;
import com.example.microservice2.infrastructure.rabbitmq.event.CustomerCreate;
import com.example.microservice2.infrastructure.rabbitmq.listener.assembler.CustomerCreateAssembler;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Component;

/**
 * Created by mtumilowicz on 2018-07-23.
 */
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@AllArgsConstructor
@Component
public class CustomerCreateMessageHandler {
    CustomerService customerService;
    
    public void process(@NonNull CustomerCreate customer) {
        customerService.save(CustomerCreateAssembler.toEntity(customer));
    }
}
