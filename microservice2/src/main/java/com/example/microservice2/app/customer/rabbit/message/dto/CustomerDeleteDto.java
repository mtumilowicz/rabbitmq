package com.example.microservice2.app.customer.rabbit.message.dto;

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
