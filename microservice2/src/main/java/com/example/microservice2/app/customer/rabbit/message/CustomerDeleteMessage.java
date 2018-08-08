package com.example.microservice2.app.customer.rabbit.message;

import com.example.microservice2.app.customer.rabbit.message.dto.CustomerDeleteDto;
import lombok.Value;
import org.apache.commons.collections4.ListUtils;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by mtumilowicz on 2018-07-18.
 */
@Value
public class CustomerDeleteMessage {
    List<CustomerDeleteDto> body;

    public List<CustomerDeleteDto> getBody() {
        return new LinkedList<>(ListUtils.emptyIfNull(body));
    }
}
