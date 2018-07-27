package com.example.microservice2.infrastructure.rabbitmq.queue;

import com.example.microservice2.infrastructure.rabbitmq.exchange.qualifier.CustomersExchange;
import com.example.microservice2.infrastructure.rabbitmq.queue.qualifier.CustomersCreateQueue;
import com.example.microservice2.infrastructure.rabbitmq.queue.qualifier.CustomersDeleteQueue;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by mtumilowicz on 2018-07-18.
 */
@Configuration
class QueueBinder {

    @Bean
    Binding customersCreateQueueBinding(@CustomersCreateQueue Queue queue,
                                        @CustomersExchange Exchange exchange) {
        return BindingBuilder.bind(queue)
                .to(exchange)
                .with("customers.create")
                .noargs();
    }

    @Bean
    Binding customersDeleteQueueBinding(@CustomersDeleteQueue Queue queue,
                                        @CustomersExchange Exchange exchange) {
        return BindingBuilder.bind(queue)
                .to(exchange)
                .with("customers.delete")
                .noargs();
    }

}
