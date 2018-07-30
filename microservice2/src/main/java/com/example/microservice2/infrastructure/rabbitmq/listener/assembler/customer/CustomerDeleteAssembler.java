package com.example.microservice2.infrastructure.rabbitmq.listener.assembler.customer;

import com.example.microservice2.infrastructure.rabbitmq.event.customer.CustomerDelete;
import lombok.NonNull;

import java.util.Objects;

/**
 * Created by mtumilowicz on 2018-07-23.
 */
public class CustomerDeleteAssembler {
    public static Integer id(@NonNull CustomerDelete customerDelete) {
        return Objects.requireNonNull(customerDelete.getId());
    }
}
