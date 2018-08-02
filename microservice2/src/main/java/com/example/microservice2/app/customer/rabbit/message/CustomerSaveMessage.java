package com.example.microservice2.app.customer.rabbit.message;

import com.example.microservice2.app.customer.rabbit.dto.CustomerSaveDto;
import lombok.Builder;
import lombok.Value;

import java.util.List;

/**
 * Created by mtumilowicz on 2018-08-01.
 */
@Value
@Builder
public class CustomerSaveMessage {
    // TO-DO configure serializer and change to ImmutableList
    List<CustomerSaveDto> customerSaves;
}
