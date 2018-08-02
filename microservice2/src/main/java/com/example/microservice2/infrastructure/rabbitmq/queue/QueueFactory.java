package com.example.microservice2.infrastructure.rabbitmq.queue;

import com.example.microservice2.infrastructure.bean.factory.annotation.BeanFactory;
import com.example.microservice2.infrastructure.rabbitmq.queue.qualifier.CustomersCreateQueue;
import com.example.microservice2.infrastructure.rabbitmq.queue.qualifier.CustomersDeleteQueue;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;

/**
 * Created by mtumilowicz on 2018-07-17.
 */
@BeanFactory
class QueueFactory {
    @Bean
    @CustomersCreateQueue
    Queue customersCreateQueue() {
        return new Queue(QueueNames.CUSTOMERS_CREATE);
    }

    @Bean
    @CustomersDeleteQueue
    Queue customersDeleteQueue() {
        return new Queue(QueueNames.CUSTOMERS_DELETE);
    }
}
