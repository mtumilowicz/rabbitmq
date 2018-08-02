package com.example.microservice2.infrastructure.rabbitmq.queue


import spock.lang.Specification
/**
 * Created by mtumilowicz on 2018-07-20.
 */
class QueueFactoryTest extends Specification {
    def "test customersCreateQueue"() {
        given:
        def producer = new QueueFactory()

        when:
        def customersCreateQueue = producer.customersCreateQueue()

        then:
        with(customersCreateQueue) {
            name == "microservice2.customers.create"
        }
    }

    def "test customersDeleteQueue"() {
        given:
        def producer = new QueueFactory()

        when:
        def customersCreateQueue = producer.customersDeleteQueue()

        then:
        with(customersCreateQueue) {
            name == "microservice2.customers.delete"
        }
    }
}
