package com.example.microservice2.infrastructure.rabbitmq.listener.handler

import com.example.microservice2.domain.customer.model.Customer
import com.example.microservice2.domain.customer.service.CustomerService
import com.example.microservice2.infrastructure.rabbitmq.event.CustomerCreate
import spock.lang.Specification 
/**
 * Created by mtumilowicz on 2018-07-23.
 */
class CustomerCreateMessageHandlerTest extends Specification {
    def "test process"() {
        given:
        def service = Mock(CustomerService)

        and:
        def handler = new CustomerCreateMessageHandler(service)

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
        handler.process(message)
        
        then:
        1 * service.save(customer)
    }
}
