package com.example.microservice1.infrastructure.rabbitmq.publisher.customer

import com.example.microservice1.infrastructure.rabbitmq.event.customer.CustomerCreate
import com.example.microservice1.infrastructure.rabbitmq.publisher.customer.CustomerCreatePublisher
import org.springframework.amqp.core.Exchange
import org.springframework.amqp.rabbit.core.RabbitTemplate
import spock.lang.Specification

/**
 * Created by mtumilowicz on 2018-07-20.
 */
class CustomerCreatePublisherTest extends Specification {
    def "test publish"() {
        given:
        def rabbitTemplate = Mock(RabbitTemplate)

        and:
        def exchange = Mock(Exchange) {
            getName() >> "exchange"
        }

        and:
        def publisher = new CustomerCreatePublisher(rabbitTemplate, exchange)
        
        and:
        def message = CustomerCreate.builder().build()
        
        when:
        publisher.publish(message)
        
        then:
        rabbitTemplate.convertAndSend("exchange", "customers.create", message)
    }
}
