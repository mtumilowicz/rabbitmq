package com.example.microservice1.app.customer.rabbit.message.dto;

import lombok.Builder;
import lombok.Value;

/**
 * Created by mtumilowicz on 2018-07-18.
 */
@Value
@Builder
public class CustomerSaveDto {
    Integer id;
    String firstName;
}
