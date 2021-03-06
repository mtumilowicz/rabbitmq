package com.example.microservice2.infrastructure.rabbitmq.listener

import com.example.microservice2.app.customer.rabbit.CustomerListener
import com.example.microservice2.domain.customer.service.CustomerMessageHandler
import com.example.microservice2.app.customer.rabbit.message.dto.CustomerDeleteDto
import com.example.microservice2.app.customer.rabbit.message.dto.CustomerSaveDto
import com.example.microservice2.app.customer.rabbit.message.CustomerDeleteMessage
import com.example.microservice2.app.customer.rabbit.message.CustomerSaveMessage
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
        def dto = CustomerSaveDto.builder()
                .id(1)
                .firstName("firstName")
                .build()

        and:
        def message = new CustomerSaveMessage([dto])

        when:
        listener.onSave(message)

        then:
        1 * customerMessageHandler.processSave(message)
    }

    def "test onDelete"() {
        given:
        def customerMessageHandler = Mock(CustomerMessageHandler)

        and:
        def listener = new CustomerListener(customerMessageHandler)

        and:
        def dto = CustomerDeleteDto.builder()
                .id(1)
                .build()

        and:
        def message = new CustomerDeleteMessage([dto])

        when:
        listener.onDelete(message)

        then:
        1 * customerMessageHandler.processDelete(message)
    }
}
