package com.example.microservice1.infrastructure.rabbitmq.event.customer.assembler;

import com.example.microservice1.domain.customer.model.Customer;
import com.example.microservice1.infrastructure.rabbitmq.event.customer.CustomerSaveMessage;
import com.google.common.collect.ImmutableList;
import lombok.NonNull;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by mtumilowicz on 2018-08-01.
 */
public class CustomerSaveMessageAssembler {
    public static CustomerSaveMessage toMessage(@NonNull List<Customer> customers) {
        return CustomerSaveMessage
                .builder()
                .customerSaves(
                        customers.stream()
                                .map(CustomerSaveDtoAssembler::toDto)
                                .collect(Collectors.toList())
                )
                .build();
    }
    
    public static CustomerSaveMessage toMessage(@NonNull Customer customer) {
        return toMessage(ImmutableList.of(customer));
    }
}
