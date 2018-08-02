package com.example.microservice1.infrastructure.rabbitmq.message.customer

import com.example.microservice1.infrastructure.rabbitmq.message.customer.dto.CustomerDeleteDto
import spock.lang.Specification

/**
 * Created by mtumilowicz on 2018-08-02.
 */
class CustomerDeleteMessageTest extends Specification {
    def "constructor - null list"() {
        when:
        def message = new CustomerDeleteMessage(null)

        then:
        message.body == []
    }

    def "constructor - list with null elem"() {
        when:
        new CustomerDeleteMessage([null])

        then:
        thrown(NullPointerException)
    }

    def "body - check immutability"() {
        when:
        new CustomerDeleteMessage([]).body.add(new CustomerDeleteDto())

        then:
        thrown(UnsupportedOperationException)
    }
}
