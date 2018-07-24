package com.example.microservice2.infrastructure.rabbitmq.queue.producer;

/**
 * Created by mtumilowicz on 2018-07-24.
 */
public final class QueueNames {
    public final static String CUSTOMERS_CREATE = "microservice2.customers.create";
    public final static String CUSTOMERS_DELETE = "microservice2.customers.delete";

    private QueueNames() {
    }
}
