package com.example.microservice2.infrastructure.rabbitmq.consumer

import com.example.microservice2.domain.customer.model.Customer
import com.example.microservice2.domain.customer.service.CustomerService
import com.example.microservice2.infrastructure.rabbitmq.event.CustomerCreate
import spock.lang.Specification
/**
 * Created by mtumilowicz on 2018-07-20.
 */
class CustomerListenerTest extends Specification {
    def "test receive"() {
        given:
        def customerService = Mock(CustomerService)

        and:
        def listener = new CustomerListener(customerService)

        and:
        def message = CustomerCreate.builder()
                .id(1)
                .firstName("firstName")
                .build()

        and:
        def expectedCustomer = Customer.builder()
                .id(1)
                .firstName("firstName")
                .build()

        when:
        listener.receive(message)

        then:
        customerService.save({it == expectedCustomer} as Customer)
    }
}
