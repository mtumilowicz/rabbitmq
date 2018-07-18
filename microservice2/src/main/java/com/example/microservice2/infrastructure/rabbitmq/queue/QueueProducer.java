package com.example.microservice2.infrastructure.rabbitmq.queue;

import com.example.microservice2.infrastructure.rabbitmq.queue.qualifier.CustomersCreateQueue;
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
    public Queue queue() {
        return new Queue("microservice2.customers.create");
    }
}
