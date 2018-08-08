package com.example.microservice2.app.customer.rabbit.message;

import com.example.microservice2.app.customer.rabbit.message.dto.CustomerSaveDto;
import lombok.Value;
import org.apache.commons.collections4.ListUtils;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by mtumilowicz on 2018-08-01.
 */
@Value
public class CustomerSaveMessage {
    List<CustomerSaveDto> body;

    public List<CustomerSaveDto> getBody() {
        return new LinkedList<>(ListUtils.emptyIfNull(body));
    }
}
