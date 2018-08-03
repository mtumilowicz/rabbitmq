package com.example.microservice1.infrastructure.rabbitmq.message.customer.assembler;

import com.example.microservice1.domain.customer.model.Customer;
import com.example.microservice1.infrastructure.mapper.ModelMapperFactory;
import com.example.microservice1.infrastructure.rabbitmq.message.customer.dto.CustomerSaveDto;
import lombok.NonNull;

/**
 * Created by mtumilowicz on 2018-07-19.
 */
class CustomerSaveDtoAssembler {

    static CustomerSaveDto toDto(@NonNull Customer customer) {
        return ModelMapperFactory.directFieldMapper().map(customer, CustomerSaveDto.class);
    }
}
