package com.example.microservice2.infrastructure.rabbitmq.listener.assembler.customer;

import com.example.microservice2.domain.customer.model.Customer;
import com.example.microservice2.infrastructure.rabbitmq.event.customer.CustomerCreate;
import lombok.NonNull;

/**
 * Created by mtumilowicz on 2018-07-20.
 */
public class CustomerCreateAssembler {
    public static Customer toEntity(@NonNull CustomerCreate customerCreate) {
        return Customer.builder()
                .id(customerCreate.getId())
                .firstName(customerCreate.getFirstName())
                .build();
    }
}
