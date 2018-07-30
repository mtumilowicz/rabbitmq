package com.example.microservice1.infrastructure.rabbitmq.publisher.customer;

import com.example.microservice1.infrastructure.rabbitmq.annotation.RabbitPublisher;
import com.example.microservice1.infrastructure.rabbitmq.event.customer.CustomerCreate;
import com.example.microservice1.infrastructure.rabbitmq.exchange.qualifier.CustomersExchange;
import lombok.AccessLevel;
import lombok.NonNull;
import lombok.experimental.FieldDefaults;
import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;

/**
 * Created by mtumilowicz on 2018-07-17.
 */
@RabbitPublisher
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
class CustomerCreatePublisher {
    RabbitTemplate rabbitTemplate;
    Exchange exchange;

    CustomerCreatePublisher(RabbitTemplate rabbitTemplate, @CustomersExchange Exchange exchange) {
        this.rabbitTemplate = rabbitTemplate;
        this.exchange = exchange;
    }

    void publish(@NonNull CustomerCreate customerCreate) {
        rabbitTemplate.convertAndSend(
                exchange.getName(), 
                "customers.create",
                customerCreate);
    }
}
