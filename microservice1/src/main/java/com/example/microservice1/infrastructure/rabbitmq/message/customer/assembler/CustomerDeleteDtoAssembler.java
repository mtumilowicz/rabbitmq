package com.example.microservice1.infrastructure.rabbitmq.message.customer.assembler;

import com.example.microservice1.infrastructure.rabbitmq.message.customer.dto.CustomerDeleteDto;
import lombok.NonNull;

/**
 * Created by mtumilowicz on 2018-07-23.
 */
class CustomerDeleteDtoAssembler {
    static CustomerDeleteDto toDto(@NonNull Integer id) {
        return CustomerDeleteDto.builder()
                .id(id)
                .build();
    }
}
