package com.example.microservice1.infrastructure.rabbitmq.event.customer.assembler;

import com.example.microservice1.domain.customer.model.Customer;
import com.example.microservice1.infrastructure.rabbitmq.event.customer.CustomerCreate;
import lombok.NonNull;

/**
 * Created by mtumilowicz on 2018-07-19.
 */
public class CustomerCreateAssembler {
    public static CustomerCreate toEvent(@NonNull Customer customer) {
        return CustomerCreate.builder()
                .id(customer.getId())
                .firstName(customer.getFirstName())
                .build();
    }
}
