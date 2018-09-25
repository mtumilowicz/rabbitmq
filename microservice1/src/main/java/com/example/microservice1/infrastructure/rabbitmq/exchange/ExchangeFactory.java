package com.example.microservice1.infrastructure.rabbitmq.exchange;

import com.example.microservice1.infrastructure.bean.factory.annotation.BeanFactory;
import com.example.microservice1.infrastructure.rabbitmq.exchange.qualifier.CustomersExchange;
import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.core.ExchangeBuilder;
import org.springframework.context.annotation.Bean;

/**
 * Created by mtumilowicz on 2018-07-16.
 */
@BeanFactory 
class ExchangeFactory {
    
    @Bean
    @CustomersExchange
    Exchange customersExchange() {
        return ExchangeBuilder.directExchange(ExchangeNames.CUSTOMERS)
                .durable(true)
                .build();
    }
}
