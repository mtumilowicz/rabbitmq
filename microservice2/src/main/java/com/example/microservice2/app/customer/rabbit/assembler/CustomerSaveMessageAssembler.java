package com.example.microservice2.app.customer.rabbit.assembler;

import com.example.microservice2.domain.customer.model.Customer;
import com.example.microservice2.app.customer.rabbit.message.CustomerSaveMessage;
import lombok.NonNull;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by mtumilowicz on 2018-08-01.
 */
public class CustomerSaveMessageAssembler {
    public static List<Customer> toEntities(@NonNull CustomerSaveMessage message) {
        return message.getCustomerSaves()
                .stream()
                .map(CustomerSaveDtoAssembler::toEntity)
                .collect(Collectors.toList());
    }
}
