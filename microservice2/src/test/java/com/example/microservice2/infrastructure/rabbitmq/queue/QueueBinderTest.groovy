package com.example.microservice2.infrastructure.rabbitmq.queue

import com.example.microservice2.infrastructure.rabbitmq.queue.binder.QueueBinder
import org.springframework.amqp.core.Exchange
import org.springframework.amqp.core.Queue
import spock.lang.Specification
/**
 * Created by mtumilowicz on 2018-07-20.
 */
class QueueBinderTest extends Specification {
    def "test customersCreateQueueBinding"() {
        given:
        def binder = new QueueBinder()

        when:
        def binding = binder.customersCreateQueueBinding(Mock(Queue), Mock(Exchange))

        then:
        binding.routingKey == "customers.create"
    }

    def "test customersDeleteQueueBinding"() {
        given:
        def binder = new QueueBinder()

        when:
        def binding = binder.customersDeleteQueueBinding(Mock(Queue), Mock(Exchange))

        then:
        binding.routingKey == "customers.delete"
    }
}
