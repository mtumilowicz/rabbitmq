package com.example.microservice1.infrastructure.rabbitmq.event.assembler

import com.example.microservice1.domain.customer.model.Customer
import spock.lang.Specification
/**
 * Created by mtumilowicz on 2018-07-20.
 */
class CustomerCreateAssemblerTest extends Specification {
    def "test toEvent"() {
        given:
        def customer = Customer.builder()
                .id(1)
                .firstName("firstName")
                .build()

        when:
        def event = CustomerCreateAssembler.toEvent(customer)

        then:
        with(event) {
            id == 1
            firstName == "firstName"
        }
    }
}
