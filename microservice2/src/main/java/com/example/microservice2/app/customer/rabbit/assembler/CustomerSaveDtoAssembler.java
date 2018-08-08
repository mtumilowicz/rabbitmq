package com.example.microservice2.app.customer.rabbit.assembler;

import com.example.microservice2.app.customer.rabbit.message.dto.CustomerSaveDto;
import com.example.microservice2.domain.customer.model.Customer;
import com.example.microservice2.infrastructure.mapper.ModelMapperFactory;
import lombok.NonNull;

/**
 * Created by mtumilowicz on 2018-07-19.
 */
class CustomerSaveDtoAssembler {
    static Customer toEntity(@NonNull CustomerSaveDto dto) {
        return ModelMapperFactory.directFieldMapper().map(dto, Customer.class);
    }
}
