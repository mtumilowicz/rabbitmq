package com.example.microservice1.app.customer.rabbit.message.assembler;

import com.example.microservice1.app.customer.rabbit.message.CustomerDeleteMessage;
import com.google.common.collect.ImmutableList;
import lombok.NonNull;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by mtumilowicz on 2018-08-01.
 */
public class CustomerDeleteMessageAssembler {
    public static CustomerDeleteMessage toMessage(@NonNull List<Integer> ids) {
        return new CustomerDeleteMessage(
                        ids.stream()
                                .map(CustomerDeleteDtoAssembler::toDto)
                                .collect(Collectors.toList())
                );
    }

    public static CustomerDeleteMessage toMessage(@NonNull Integer id) {
        return toMessage(ImmutableList.of(id));
    }
}
