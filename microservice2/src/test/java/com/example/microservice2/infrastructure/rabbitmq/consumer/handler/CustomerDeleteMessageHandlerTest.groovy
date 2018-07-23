package com.example.microservice2.infrastructure.rabbitmq.consumer.handler

import com.example.microservice2.domain.customer.service.CustomerService
import spock.lang.Specification
/**
 * Created by mtumilowicz on 2018-07-23.
 */
class CustomerDeleteMessageHandlerTest extends Specification {
    def "test receive"() {
        given:
        def service = Mock(CustomerService)

        and:
        def handler = new CustomerDeleteMessageHandler(service)
        
        when:
        handler.receive(1)

        then:
        1 * service.deleteById(1)
    }
}
