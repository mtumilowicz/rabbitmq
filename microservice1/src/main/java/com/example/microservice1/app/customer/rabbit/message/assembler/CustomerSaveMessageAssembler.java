package com.example.microservice1.app.customer.rabbit.message.assembler;

import com.example.microservice1.domain.customer.model.Customer;
import com.example.microservice1.app.customer.rabbit.message.CustomerSaveMessage;
import com.google.common.collect.ImmutableList;
import lombok.NonNull;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by mtumilowicz on 2018-08-01.
 */
public class CustomerSaveMessageAssembler {
    public static CustomerSaveMessage toMessage(@NonNull List<Customer> customers) {
        return new CustomerSaveMessage(
                        customers.stream()
                                .map(CustomerSaveDtoAssembler::toDto)
                                .collect(Collectors.toList())
                );
    }
    
    public static CustomerSaveMessage toMessage(@NonNull Customer customer) {
        return toMessage(ImmutableList.of(customer));
    }
}
