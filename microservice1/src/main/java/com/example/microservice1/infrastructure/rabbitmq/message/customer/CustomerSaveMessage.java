package com.example.microservice1.infrastructure.rabbitmq.message.customer;

import com.example.microservice1.infrastructure.rabbitmq.message.customer.dto.CustomerSaveDto;
import lombok.Builder;
import lombok.Value;

import java.util.List;

/**
 * Created by mtumilowicz on 2018-08-01.
 */
@Value
@Builder
public class CustomerSaveMessage {
    List<CustomerSaveDto> body;
}
