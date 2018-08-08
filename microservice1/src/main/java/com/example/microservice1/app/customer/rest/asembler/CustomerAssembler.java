package com.example.microservice1.app.customer.rest.asembler;

import com.example.microservice1.app.customer.rest.dto.CustomerDto;
import com.example.microservice1.domain.customer.model.Customer;
import com.example.microservice1.infrastructure.mapper.ModelMapperFactory;
import lombok.AccessLevel;
import lombok.NonNull;
import lombok.experimental.FieldDefaults;

/**
 * Created by mtumilowicz on 2018-07-19.
 */
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class CustomerAssembler {
    public static Customer toEntity(@NonNull CustomerDto dto) {
        return ModelMapperFactory.directFieldMapper().map(dto, Customer.class);
    }
}
