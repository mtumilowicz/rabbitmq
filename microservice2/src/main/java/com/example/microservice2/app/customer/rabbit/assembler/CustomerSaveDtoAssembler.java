package com.example.microservice2.app.customer.rabbit.assembler;

import com.example.microservice2.app.customer.rabbit.dto.CustomerSaveDto;
import com.example.microservice2.domain.customer.model.Customer;
import lombok.NonNull;

/**
 * Created by mtumilowicz on 2018-07-19.
 */
class CustomerSaveDtoAssembler {
    static Customer toEntity(@NonNull CustomerSaveDto dto) {
        return Customer.builder()
                .id(dto.getId())
                .firstName(dto.getFirstName())
                .build();
    }
}
