package com.example.microservice2.infrastructure.rabbitmq.queue.producer;

import com.example.microservice2.infrastructure.rabbitmq.queue.qualifier.CustomersCreateQueue;
import com.example.microservice2.infrastructure.rabbitmq.queue.qualifier.CustomersDeleteQueue;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * Created by mtumilowicz on 2018-07-17.
 */
@Component
public class QueueProducer {
    @Bean
    @CustomersCreateQueue
    public Queue customersCreateQueue() {
        return new Queue(QueueNames.CUSTOMERS_CREATE);
    }

    @Bean
    @CustomersDeleteQueue
    public Queue customersDeleteQueue() {
        return new Queue(QueueNames.CUSTOMERS_DELETE);
    }
}
