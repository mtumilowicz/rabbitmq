package com.example.microservice2.infrastructure.rabbitmq.consumer;

import com.example.microservice2.domain.customer.service.CustomerService;
import com.example.microservice2.infrastructure.rabbitmq.annotation.RabbitConsumer;
import com.example.microservice2.infrastructure.rabbitmq.event.CustomerCreate;
import com.example.microservice2.infrastructure.rabbitmq.event.assembler.CustomerAssembler;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.amqp.rabbit.annotation.RabbitListener;

/**
 * Created by mtumilowicz on 2018-07-17.
 */
@RabbitConsumer
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@AllArgsConstructor
public class CustomerListener {
    
    CustomerService customerService;
    
    @RabbitListener(queues = "microservice2.customers.create")
    public void receive(CustomerCreate customerCreate) {
        customerService.save(CustomerAssembler.toEntity(customerCreate));
    }
}
