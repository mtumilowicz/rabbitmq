package com.example.microservice2.infrastructure.rabbitmq.queue;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * Created by mtumilowicz on 2018-07-24.
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class QueueNames {
    public final static String CUSTOMERS_CREATE = "microservice2.customers.create";
    public final static String CUSTOMERS_DELETE = "microservice2.customers.delete";
}
