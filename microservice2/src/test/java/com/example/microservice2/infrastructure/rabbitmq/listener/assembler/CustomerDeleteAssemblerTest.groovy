package com.example.microservice2.infrastructure.rabbitmq.listener.assembler

import com.example.microservice2.infrastructure.rabbitmq.event.CustomerDelete
import spock.lang.Specification

/**
 * Created by mtumilowicz on 2018-07-27.
 */
class CustomerDeleteAssemblerTest extends Specification {
    def "test id"() {
        given:
        def customerDelete = CustomerDelete.builder()
                .id(1)
                .build()

        expect:
        1 == CustomerDeleteAssembler.id(customerDelete)
    }
}
