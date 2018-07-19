package com.example.microservice1.infrastructure.rabbitmq.event.assembler;

import com.example.microservice1.domain.customer.model.Customer;
import com.example.microservice1.infrastructure.rabbitmq.event.CustomerCreate;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.modelmapper.ModelMapper;

/**
 * Created by mtumilowicz on 2018-07-19.
 */
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class CustomerCreateAssembler {
    static ModelMapper mapper = new ModelMapper();

    public static CustomerCreate toEvent(Customer customer) {
        return mapper.map(customer, CustomerCreate.class);
    }
}
