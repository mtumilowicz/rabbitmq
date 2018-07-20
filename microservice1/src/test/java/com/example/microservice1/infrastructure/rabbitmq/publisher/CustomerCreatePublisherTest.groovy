package com.example.microservice1.infrastructure.rabbitmq.publisher

import com.example.microservice1.infrastructure.rabbitmq.event.CustomerCreate
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
        def customersExchange = Mock(Exchange) {
            getName() >> "exchange"
        }

        and:
        def createPublisher = new CustomerCreatePublisher(rabbitTemplate, customersExchange)
        
        and:
        def message = CustomerCreate.builder().build()
        
        when:
        createPublisher.publish(message)
        
        then:
        rabbitTemplate.convertAndSend("exchange", "customers.create", message)
    }
}
