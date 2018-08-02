package com.example.microservice2.app.customer.rabbit.message;

import com.example.microservice2.app.customer.rabbit.dto.CustomerDeleteDto;
import com.google.common.collect.ImmutableList;
import lombok.Value;
import org.apache.commons.collections4.ListUtils;

import java.util.List;

/**
 * Created by mtumilowicz on 2018-07-18.
 */
@Value
public class CustomerDeleteMessage {
    List<CustomerDeleteDto> body;

    public ImmutableList<CustomerDeleteDto> getBody() {
        return ImmutableList.copyOf(ListUtils.emptyIfNull(body));
    }
}
