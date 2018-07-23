package com.example.microservice1.infrastructure.rabbitmq.event.assembler;

import com.example.microservice1.infrastructure.rabbitmq.event.CustomerDelete;
import lombok.NonNull;

/**
 * Created by mtumilowicz on 2018-07-23.
 */
public class CustomerDeleteAssembler {
    public static CustomerDelete toEvent(@NonNull Integer id) {
        return CustomerDelete.builder()
                .id(id)
                .build();
    }
}
