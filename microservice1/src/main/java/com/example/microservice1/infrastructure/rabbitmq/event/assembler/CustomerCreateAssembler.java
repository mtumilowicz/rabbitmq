package com.example.microservice1.infrastructure.rabbitmq.event.assembler;

import com.example.microservice1.domain.customer.model.Customer;
import com.example.microservice1.infrastructure.rabbitmq.event.CustomerCreate;
import lombok.AccessLevel;
import lombok.NonNull;
import lombok.experimental.FieldDefaults;

/**
 * Created by mtumilowicz on 2018-07-19.
 */
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class CustomerCreateAssembler {
    public static CustomerCreate toEvent(@NonNull Customer customer) {
        return CustomerCreate.builder()
                .id(customer.getId())
                .firstName(customer.getFirstName())
                .build();
    }
}
