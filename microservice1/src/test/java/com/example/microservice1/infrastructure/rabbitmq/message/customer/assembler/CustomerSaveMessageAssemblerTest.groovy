package com.example.microservice1.infrastructure.rabbitmq.message.customer.assembler


import com.example.microservice1.domain.customer.model.Customer
import com.example.microservice1.infrastructure.rabbitmq.message.customer.dto.CustomerSaveDto
import spock.lang.Specification

/**
 * Created by mtumilowicz on 2018-08-01.
 */
class CustomerSaveMessageAssemblerTest extends Specification {
    def "test toMessage - list"() {
        given:
        def customer = Customer.builder()
                .id(_id)
                .firstName(_firstName)
                .build()

        and:
        def customerDto = CustomerSaveDto.builder()
                .id(_id)
                .firstName(_firstName)
                .build()

        when:
        def message = CustomerSaveMessageAssembler.toMessage([customer])

        then:
        with(message) {
            body == [customerDto]
        }

        where:
        _id  | _firstName
        1    | "firstName"
        null | null
    }

    def "test toMessage - single"() {
        given:
        def customer = Customer.builder()
                .id(_id)
                .firstName(_firstName)
                .build()

        and:
        def customerDto = CustomerSaveDto.builder()
                .id(_id)
                .firstName(_firstName)
                .build()

        when:
        def message = CustomerSaveMessageAssembler.toMessage(customer)

        then:
        with(message) {
            body == [customerDto]
        }

        where:
        _id  | _firstName
        1    | "firstName"
        null | null
    }
}
