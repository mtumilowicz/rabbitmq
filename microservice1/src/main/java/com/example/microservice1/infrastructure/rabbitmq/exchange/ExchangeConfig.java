package com.example.microservice1.infrastructure.rabbitmq.exchange;

import com.example.microservice1.infrastructure.rabbitmq.exchange.qualifier.CustomersExchange;
import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.core.ExchangeBuilder;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by mtumilowicz on 2018-07-16.
 */
@Configuration
@EnableRabbit
public class ExchangeConfig {
    
    @Bean
    @CustomersExchange
    public Exchange customersExchange() {
        return ExchangeBuilder.topicExchange("customers")
                .durable(true)
                .build();
    }
}
