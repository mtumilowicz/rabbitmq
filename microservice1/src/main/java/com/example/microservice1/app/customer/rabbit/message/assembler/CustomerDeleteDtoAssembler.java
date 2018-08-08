package com.example.microservice1.app.customer.rabbit.message.assembler;

import com.example.microservice1.app.customer.rabbit.message.dto.CustomerDeleteDto;
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
