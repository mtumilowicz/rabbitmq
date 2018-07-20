package com.example.microservice1.infrastructure.rabbitmq.publisher;

import com.example.microservice1.infrastructure.rabbitmq.annotation.RabbitPublisher;
import com.example.microservice1.infrastructure.rabbitmq.event.CustomerCreate;
import com.example.microservice1.infrastructure.rabbitmq.exchange.qualifier.CustomersExchange;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.experimental.FieldDefaults;
import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;

/**
 * Created by mtumilowicz on 2018-07-17.
 */
@RabbitPublisher
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
class CustomerCreatePublisher {
    RabbitTemplate rabbitTemplate;
    @CustomersExchange Exchange exchange;

    void publish(@NonNull CustomerCreate customerCreate) {
        rabbitTemplate.convertAndSend(
                exchange.getName(), 
                "customers.create",
                customerCreate);
    }
}
