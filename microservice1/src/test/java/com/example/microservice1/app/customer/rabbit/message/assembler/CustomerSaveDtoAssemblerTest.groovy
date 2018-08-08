package com.example.microservice1.app.customer.rabbit.message.assembler

import com.example.microservice1.domain.customer.model.Customer
import spock.lang.Specification

/**
 * Created by mtumilowicz on 2018-07-20.
 */
class CustomerSaveDtoAssemblerTest extends Specification {
    def "test toEvent"() {
        given:
        def customer = Customer.builder()
                .id(1)
                .firstName("firstName")
                .build()

        when:
        def event = CustomerSaveDtoAssembler.toDto(customer)

        then:
        with(event) {
            id == 1
            firstName == "firstName"
        }

        where:
        _id  | _firstName
        1    | "firstName"
        null | null
    }
}
