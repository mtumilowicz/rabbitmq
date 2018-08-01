package com.example.microservice1.infrastructure.rabbitmq.event.customer;

import com.example.microservice1.infrastructure.rabbitmq.event.customer.dto.CustomerDeleteDto;
import lombok.Builder;
import lombok.Value;

import java.util.List;

/**
 * Created by mtumilowicz on 2018-07-18.
 */
@Value
@Builder
public class CustomerDeleteMessage {
        // TO-DO configure serializer and change to ImmutableList
    List<CustomerDeleteDto> ids;
}
