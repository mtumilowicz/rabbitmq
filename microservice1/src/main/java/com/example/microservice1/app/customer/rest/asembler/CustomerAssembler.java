package com.example.microservice1.app.customer.rest.asembler;

import com.example.microservice1.domain.customer.model.Customer;
import com.example.microservice1.app.customer.rest.dto.CustomerDto;
import lombok.AccessLevel;
import lombok.NonNull;
import lombok.experimental.FieldDefaults;
import org.modelmapper.ModelMapper;

/**
 * Created by mtumilowicz on 2018-07-19.
 */
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class CustomerAssembler {
    private static ModelMapper mapper = new ModelMapper();

    public static Customer toEntity(@NonNull CustomerDto dto) {
        return mapper.map(dto, Customer.class);
    }
}
