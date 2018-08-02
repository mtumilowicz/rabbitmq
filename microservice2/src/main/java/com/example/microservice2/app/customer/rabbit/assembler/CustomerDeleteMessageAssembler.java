package com.example.microservice2.app.customer.rabbit.assembler;

import com.example.microservice2.app.customer.rabbit.message.CustomerDeleteMessage;
import lombok.NonNull;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by mtumilowicz on 2018-08-01.
 */
public class CustomerDeleteMessageAssembler {
    public static List<Integer> extractIds(@NonNull CustomerDeleteMessage message) {
        return message.getBody()
                .stream()
                .map(CustomerDeleteDtoAssembler::extractId)
                .collect(Collectors.toList());
    }
}
