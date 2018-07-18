package com.example.microservice1.infrastructure.customer.rabbitmq;

import com.example.microservice1.infrastructure.rabbitmq.annotation.RabbitPublisher;
import com.example.microservice1.infrastructure.rabbitmq.exchange.qualifier.CustomersExchange;
import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;

/**
 * Created by mtumilowicz on 2018-07-17.
 */
@RabbitPublisher
public class CustomerCreatePublisher {
    private final RabbitTemplate rabbitTemplate;
    private final Exchange exchange;

    public CustomerCreatePublisher(RabbitTemplate rabbitTemplate, @CustomersExchange Exchange exchange) {
        this.rabbitTemplate = rabbitTemplate;
        this.exchange = exchange;
    }

    public void publish() {
        rabbitTemplate.convertAndSend(
                exchange.getName(), 
                "customers.create", 
                "CUSTOMER CREATE!");
    }
}
