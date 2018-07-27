package com.example.microservice2.infrastructure.rabbitmq.exchange;

import com.example.microservice2.infrastructure.rabbitmq.exchange.qualifier.CustomersExchange;
import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.core.ExchangeBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by mtumilowicz on 2018-07-18.
 */
@Configuration
class ExchangeProducer {

    @Bean
    @CustomersExchange
    Exchange customersExchange() {
        return ExchangeBuilder.topicExchange(ExchangeNames.CUSTOMERS)
                .durable(true)
                .build();
    }
}
