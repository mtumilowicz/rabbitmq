package com.example.microservice2.app.customer.rabbit

import com.example.microservice2.app.customer.rabbit.CustomerListener
import com.example.microservice2.infrastructure.rabbitmq.event.customer.CustomerCreate
import com.example.microservice2.infrastructure.rabbitmq.event.customer.CustomerDelete
import com.example.microservice2.infrastructure.rabbitmq.listener.handler.customer.CustomerMessageHandler
import spock.lang.Specification 
/**
 * Created by mtumilowicz on 2018-07-20.
 */
class CustomerListenerTest extends Specification {
    def "test onCreate"() {
        given:
        def customerMessageHandler = Mock(CustomerMessageHandler)

        and:
        def listener = new CustomerListener(customerMessageHandler)

        and:
        def message = CustomerCreate.builder()
                .id(1)
                .firstName("firstName")
                .build()
        when:
        listener.onCreate(message)

        then:
        1 * customerMessageHandler.processCreate(message)
    }

    def "test onDelete"() {
        given:
        def customerMessageHandler = Mock(CustomerMessageHandler)

        and:
        def listener = new CustomerListener(customerMessageHandler)

        and:
        def message = CustomerDelete.builder()
                .id(1)
                .build()

        when:
        listener.onDelete(message)

        then:
        1 * customerMessageHandler.processDelete(message)
    }
}
