package com.example.microservice2.infrastructure.rabbitmq.event;

import lombok.Builder;
import lombok.Value;

/**
 * Created by mtumilowicz on 2018-07-18.
 */
@Value
@Builder
public class CustomerCreate {
    private Integer id;
    private String firstName;
}
