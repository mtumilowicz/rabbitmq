package com.example.microservice2.infrastructure.customer.rabbitmq;

import com.example.microservice2.infrastructure.rabbitmq.annotation.RabbitConsumer;
import org.springframework.amqp.rabbit.annotation.RabbitListener;

/**
 * Created by mtumilowicz on 2018-07-17.
 */
@RabbitConsumer
public class CustomerConsumer {
    @RabbitListener(queues = "microservice2.customers.create")
    public void receive(String message) {
        System.out.println("RECEIVED MESSAGE: " + message);
    }
}
