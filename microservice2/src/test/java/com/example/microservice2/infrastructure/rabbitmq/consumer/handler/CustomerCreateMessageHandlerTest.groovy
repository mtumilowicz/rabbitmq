package com.example.microservice2.infrastructure.rabbitmq.consumer.handler

import com.example.microservice2.domain.customer.model.Customer
import com.example.microservice2.domain.customer.service.CustomerService
import spock.lang.Specification

/**
 * Created by mtumilowicz on 2018-07-23.
 */
class CustomerCreateMessageHandlerTest extends Specification {
    def "test receive"() {
        given:
        def service = Mock(CustomerService)

        and:
        def handler = new CustomerCreateMessageHandler(service)

        and:
        def customer = Customer.builder()
                .id(1)
                .firstName("firstName")
                .build()

        when:
        handler.receive(customer)
        
        then:
        1 * service.save(customer)
    }
}
