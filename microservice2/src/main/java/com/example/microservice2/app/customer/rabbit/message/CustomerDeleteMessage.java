package com.example.microservice2.app.customer.rabbit.message;

import com.example.microservice2.app.customer.rabbit.dto.CustomerDeleteDto;
import lombok.Builder;
import lombok.Value;

import java.util.List;

/**
 * Created by mtumilowicz on 2018-07-18.
 */
@Value
@Builder
public class CustomerDeleteMessage {
    List<CustomerDeleteDto> body;
}
