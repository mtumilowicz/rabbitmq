package com.example.microservice2.domain.customer.service;

import com.example.microservice2.app.customer.rabbit.assembler.CustomerDeleteMessageAssembler;
import com.example.microservice2.app.customer.rabbit.assembler.CustomerSaveMessageAssembler;
import com.example.microservice2.app.customer.rabbit.message.CustomerDeleteMessage;
import com.example.microservice2.app.customer.rabbit.message.CustomerSaveMessage;
import com.example.microservice2.domain.customer.service.CustomerService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Component;

/**
 * Created by mtumilowicz on 2018-07-30.
 */
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@AllArgsConstructor
@Component
public class CustomerMessageHandler {
    CustomerService customerService;

    public void processSave(@NonNull CustomerSaveMessage message) {
        customerService.save(CustomerSaveMessageAssembler.toEntities(message));
    }

    public void processDelete(@NonNull CustomerDeleteMessage message) {
        customerService.delete(CustomerDeleteMessageAssembler.extractIds(message));
    }
}
