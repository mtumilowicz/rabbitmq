package com.example.microservice1.infrastructure.rabbitmq.event.customer.dto;

import lombok.Builder;
import lombok.Value;

/**
 * Created by mtumilowicz on 2018-08-01.
 */
@Value
@Builder
public class CustomerDeleteDto {
    Integer id;
}
