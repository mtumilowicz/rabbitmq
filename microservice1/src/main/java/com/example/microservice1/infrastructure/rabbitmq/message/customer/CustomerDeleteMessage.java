package com.example.microservice1.infrastructure.rabbitmq.message.customer;

import com.example.microservice1.infrastructure.rabbitmq.message.customer.dto.CustomerDeleteDto;
import lombok.Builder;
import lombok.Value;

import java.util.List;

/**
 * Created by mtumilowicz on 2018-07-18.
 */
@Value
@Builder
public class CustomerDeleteMessage {
    List<CustomerDeleteDto> ids;
}
