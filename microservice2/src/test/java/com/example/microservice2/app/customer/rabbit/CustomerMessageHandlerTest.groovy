package com.example.microservice2.app.customer.rabbit

import com.example.microservice2.app.customer.rabbit.message.dto.CustomerDeleteDto
import com.example.microservice2.app.customer.rabbit.message.dto.CustomerSaveDto
import com.example.microservice2.app.customer.rabbit.message.CustomerDeleteMessage
import com.example.microservice2.app.customer.rabbit.message.CustomerSaveMessage
import com.example.microservice2.domain.customer.model.Customer
import com.example.microservice2.domain.customer.service.CustomerService
import spock.lang.Specification

/**
 * Created by mtumilowicz on 2018-07-23.
 */
class CustomerMessageHandlerTest extends Specification {
    def "test processSave"() {
        given:
        def service = Mock(CustomerService)

        and:
        def handler = new CustomerMessageHandler(service)

        and:
        def dto = CustomerSaveDto.builder()
                .id(1)
                .firstName("firstName")
                .build()

        and:
        def message = new CustomerSaveMessage([dto])

        and:
        def customer = Customer.builder()
                .id(1)
                .firstName("firstName")
                .build()

        when:
        handler.processSave(message)

        then:
        1 * service.save([customer])
    }

    def "test processDelete"() {
        given:
        def service = Mock(CustomerService)

        and:
        def handler = new CustomerMessageHandler(service)

        and:
        def dto = CustomerDeleteDto.builder()
                .id(1)
                .build()

        and:
        def message = new CustomerDeleteMessage([dto])

        when:
        handler.processDelete(message)

        then:
        1 * service.delete([1])
    }
}
