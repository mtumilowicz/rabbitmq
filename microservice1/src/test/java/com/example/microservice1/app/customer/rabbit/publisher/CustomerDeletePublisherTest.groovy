package com.example.microservice1.app.customer.rabbit.publisher

import com.example.microservice1.app.customer.rabbit.message.CustomerDeleteMessage
import com.example.microservice1.app.customer.rabbit.publisher.CustomerDeletePublisher
import org.springframework.amqp.core.Exchange
import org.springframework.amqp.rabbit.core.RabbitTemplate
import spock.lang.Specification
/**
 * Created by mtumilowicz on 2018-07-23.
 */
class CustomerDeletePublisherTest extends Specification {
    def "test publish"() {
        given:
        def rabbitTemplate = Mock(RabbitTemplate)

        and:
        def exchange = Mock(Exchange) {
            getName() >> "exchange"
        }

        and:
        def publisher = new CustomerDeletePublisher(rabbitTemplate, exchange)

        and:
        def message = new CustomerDeleteMessage([])

        when:
        publisher.publish(message)

        then:
        rabbitTemplate.convertAndSend("exchange", "customers.delete", message)
    }
}
