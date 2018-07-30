package com.example.microservice1.infrastructure.rabbitmq.event.customer;

import lombok.Builder;
import lombok.Value;

/**
 * Created by mtumilowicz on 2018-07-18.
 */
@Value
@Builder
public class CustomerDelete {
    Integer id;
}
