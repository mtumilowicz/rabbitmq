package com.example.microservice2.infrastructure.rabbitmq.consumer

import com.example.microservice2.domain.customer.model.Customer
import com.example.microservice2.infrastructure.rabbitmq.consumer.handler.CustomerCreateMessageHandler
import com.example.microservice2.infrastructure.rabbitmq.consumer.handler.CustomerDeleteMessageHandler
import com.example.microservice2.infrastructure.rabbitmq.event.CustomerCreate
import com.example.microservice2.infrastructure.rabbitmq.event.CustomerDelete
import spock.lang.Specification

/**
 * Created by mtumilowicz on 2018-07-20.
 */
class CustomerListenerTest extends Specification {
    def "test onCreate"() {
        given:
        def createMessageHandler = Mock(CustomerCreateMessageHandler)

        and:
        def listener = new CustomerListener(createMessageHandler, Mock(CustomerDeleteMessageHandler))

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
        listener.onCreate(message)

        then:
        createMessageHandler.receive({ it == expectedCustomer } as Customer)
    }

    def "test onDelete"() {
        given:
        def deleteMessageHandler = Mock(CustomerDeleteMessageHandler)

        and:
        def listener = new CustomerListener(Mock(CustomerCreateMessageHandler), deleteMessageHandler)

        and:
        def customerDelete = CustomerDelete.builder()
                .id(1)
                .build()

        when:
        listener.onDelete(customerDelete)

        then:
        deleteMessageHandler.receive(1)
    }
}
