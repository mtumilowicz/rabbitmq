package com.example.microservice1.rest.customer.asembler;

import com.example.microservice1.domain.customer.model.Customer;
import com.example.microservice1.rest.customer.dto.CustomerDto;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.modelmapper.ModelMapper;

/**
 * Created by mtumilowicz on 2018-07-19.
 */
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class CustomerAssembler {
    static ModelMapper mapper = new ModelMapper();

    public static Customer toEntity(CustomerDto dto) {
        return mapper.map(dto, Customer.class);
    }
}
