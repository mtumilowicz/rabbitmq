package com.example.microservice1.infrastructure.customer.rabbitmq;

import com.example.microservice1.infrastructure.rabbitmq.annotation.RabbitPublisher;
import com.example.microservice1.infrastructure.rabbitmq.exchange.qualifier.CustomersExchange;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;

/**
 * Created by mtumilowicz on 2018-07-17.
 */
@RabbitPublisher
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class CustomerCreatePublisher {
    RabbitTemplate rabbitTemplate;
    @CustomersExchange Exchange exchange;

    public void publish() {
        rabbitTemplate.convertAndSend(
                exchange.getName(), 
                "customers.create", 
                "CUSTOMER CREATE!");
    }
}
