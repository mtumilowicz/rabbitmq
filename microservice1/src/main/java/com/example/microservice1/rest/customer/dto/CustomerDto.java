package com.example.microservice1.rest.customer.dto;

import lombok.Builder;
import lombok.Value;

/**
 * Created by mtumilowicz on 2018-07-19.
 */
@Value
@Builder
public class CustomerDto {
    private String firstName;
}