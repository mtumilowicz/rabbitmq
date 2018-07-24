package com.example.microservice1.infrastructure.rabbitmq.exchange;

import lombok.experimental.FieldNameConstants;

/**
 * Created by mtumilowicz on 2018-07-24.
 */
@FieldNameConstants(prefix = "")
final class ExchangeNames {
    String customers;

    private ExchangeNames() {
    }
}
