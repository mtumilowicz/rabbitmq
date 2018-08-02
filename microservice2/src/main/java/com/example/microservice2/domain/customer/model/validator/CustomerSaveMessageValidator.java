package com.example.microservice2.domain.customer.model.validator;

import com.example.microservice2.app.customer.rabbit.dto.CustomerSaveDto;
import com.example.microservice2.app.customer.rabbit.message.CustomerSaveMessage;
import com.google.common.base.Preconditions;
import lombok.NonNull;

import java.util.Objects;

import static java.util.Objects.nonNull;

/**
 * Created by mtumilowicz on 2018-08-02.
 */
public class CustomerSaveMessageValidator {
    public static void validate(@NonNull CustomerSaveMessage message) {
        Preconditions.checkState(nonNull(message.getBody()));
        Preconditions.checkState(message.getBody().stream().allMatch(Objects::nonNull));
        Preconditions.checkState(message.getBody().stream().map(CustomerSaveDto::getId).allMatch(Objects::nonNull));
    }
}
