package com.example.microservice1.app.customer.rabbit.message;

import com.example.microservice1.app.customer.rabbit.message.dto.CustomerSaveDto;
import com.google.common.collect.ImmutableList;
import lombok.Value;
import org.apache.commons.collections4.ListUtils;

import java.util.List;

/**
 * Created by mtumilowicz on 2018-08-01.
 */
@Value
public class CustomerSaveMessage {
    ImmutableList<CustomerSaveDto> body;

    public CustomerSaveMessage(List<CustomerSaveDto> body) {
        this.body = ImmutableList.copyOf(ListUtils.emptyIfNull(body));
    }
}
