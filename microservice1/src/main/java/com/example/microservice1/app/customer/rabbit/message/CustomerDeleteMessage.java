package com.example.microservice1.app.customer.rabbit.message;

import com.example.microservice1.app.customer.rabbit.message.dto.CustomerDeleteDto;
import com.google.common.collect.ImmutableList;
import lombok.Value;
import org.apache.commons.collections4.ListUtils;

import java.util.List;

/**
 * Created by mtumilowicz on 2018-07-18.
 */
@Value
public class CustomerDeleteMessage {
    ImmutableList<CustomerDeleteDto> body;

    public CustomerDeleteMessage(List<CustomerDeleteDto> body) {
        this.body = ImmutableList.copyOf(ListUtils.emptyIfNull(body));
    }
}
