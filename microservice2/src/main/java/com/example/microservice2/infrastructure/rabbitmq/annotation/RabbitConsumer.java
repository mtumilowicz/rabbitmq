package com.example.microservice2.infrastructure.rabbitmq.annotation;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.stereotype.Service;

/**
 * Created by mtumilowicz on 2018-07-18.
 */
@Service
@EnableRabbit
public @interface RabbitConsumer {
}
