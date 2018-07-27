package com.example.microservice2.infrastructure.rabbitmq.listener.handler

import com.example.microservice2.domain.customer.service.CustomerService
import com.example.microservice2.infrastructure.rabbitmq.event.CustomerDelete
import spock.lang.Specification
/**
 * Created by mtumilowicz on 2018-07-23.
 */
class CustomerDeleteMessageHandlerTest extends Specification {
    def "test process"() {
        given:
        def service = Mock(CustomerService)

        and:
        def handler = new CustomerDeleteMessageHandler(service)
        
        and:
        def message = CustomerDelete.builder()
                .id(1)
                .build()
        
        when:
        handler.process(message)

        then:
        1 * service.deleteById(1)
    }
}
