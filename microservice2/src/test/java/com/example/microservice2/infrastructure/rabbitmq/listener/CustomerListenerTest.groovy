package com.example.microservice2.infrastructure.rabbitmq.listener


import com.example.microservice2.infrastructure.rabbitmq.listener.handler.CustomerCreateMessageHandler
import com.example.microservice2.infrastructure.rabbitmq.listener.handler.CustomerDeleteMessageHandler
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
        when:
        listener.onCreate(message)

        then:
        1 * createMessageHandler.process(message)
    }

    def "test onDelete"() {
        given:
        def deleteMessageHandler = Mock(CustomerDeleteMessageHandler)

        and:
        def listener = new CustomerListener(Mock(CustomerCreateMessageHandler), deleteMessageHandler)

        and:
        def message = CustomerDelete.builder()
                .id(1)
                .build()

        when:
        listener.onDelete(message)

        then:
        1 * deleteMessageHandler.process(message)
    }
}
