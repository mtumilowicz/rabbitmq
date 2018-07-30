package com.example.microservice1.infrastructure.rabbitmq.publisher.customer;

import com.example.microservice1.domain.customer.model.Customer;
import com.example.microservice1.infrastructure.rabbitmq.annotation.RabbitPublisher;
import com.example.microservice1.infrastructure.rabbitmq.event.customer.assembler.CustomerCreateAssembler;
import com.example.microservice1.infrastructure.rabbitmq.event.customer.assembler.CustomerDeleteAssembler;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;

/**
 * Created by mtumilowicz on 2018-07-20.
 */
@RabbitPublisher
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class CustomerPublisher {
    CustomerCreatePublisher createPublisher;
    CustomerDeletePublisher deletePublisher;
    
    public void publishCreate(Customer customer) {
        createPublisher.publish(CustomerCreateAssembler.toEvent(customer));
    }
    
    public void publishDelete(Integer id) {
        deletePublisher.publish(CustomerDeleteAssembler.toEvent(id));
    }
}
