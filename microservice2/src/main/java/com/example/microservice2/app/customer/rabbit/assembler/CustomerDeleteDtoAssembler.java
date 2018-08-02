package com.example.microservice2.app.customer.rabbit.assembler;

import com.example.microservice2.app.customer.rabbit.dto.CustomerDeleteDto;
import lombok.NonNull;

/**
 * Created by mtumilowicz on 2018-07-23.
 */
class CustomerDeleteDtoAssembler {
    static Integer extractId(@NonNull CustomerDeleteDto dto) {
        return dto.getId();
    }
}
