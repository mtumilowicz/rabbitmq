package com.example.microservice1.infrastructure.rabbitmq.exchange

import spock.lang.Specification
/**
 * Created by mtumilowicz on 2018-07-20.
 */
class ExchangeProducerTest extends Specification {
    def "test customersExchange"() {
        when:
        def customersExchange = new ExchangeProducer().customersExchange()
        
        then:
        with(customersExchange) {
            name == "customers"
            type == "topic"
            isDurable()
        }
    }
}
