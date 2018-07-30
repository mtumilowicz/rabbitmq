package com.example.microservice2.infrastructure.rabbitmq.listener.handler

import com.example.microservice2.domain.customer.model.Customer
import com.example.microservice2.domain.customer.service.CustomerService
import com.example.microservice2.infrastructure.rabbitmq.event.CustomerCreate
import com.example.microservice2.infrastructure.rabbitmq.event.CustomerDelete
import spock.lang.Specification 
/**
 * Created by mtumilowicz on 2018-07-23.
 */
class CustomerMessageHandlerTest extends Specification {
    def "test processCreate"() {
        given:
        def service = Mock(CustomerService)

        and:
        def handler = new CustomerMessageHandler(service)

        and:
        def message = CustomerCreate.builder()
                .id(1)
                .firstName("firstName")
                .build()
        
        and:
        def customer = Customer.builder()
                .id(1)
                .firstName("firstName")
                .build()

        when:
        handler.processCreate(message)
        
        then:
        1 * service.save(customer)
    }

    def "test processDelete"() {
        given:
        def service = Mock(CustomerService)

        and:
        def handler = new CustomerMessageHandler(service)

        and:
        def message = CustomerDelete.builder()
                .id(1)
                .build()

        when:
        handler.processDelete(message)

        then:
        1 * service.deleteById(1)
    }
}
