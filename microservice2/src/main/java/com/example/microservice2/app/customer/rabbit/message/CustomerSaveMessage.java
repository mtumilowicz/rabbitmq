package com.example.microservice2.app.customer.rabbit.message;

import com.example.microservice2.app.customer.rabbit.dto.CustomerSaveDto;
import com.google.common.collect.ImmutableList;
import lombok.Value;
import org.apache.commons.collections4.ListUtils;

import java.util.List;

/**
 * Created by mtumilowicz on 2018-08-01.
 */
@Value
public class CustomerSaveMessage {
    List<CustomerSaveDto> body;

    public ImmutableList<CustomerSaveDto> getBody() {
        return ImmutableList.copyOf(ListUtils.emptyIfNull(body));
    }
}
