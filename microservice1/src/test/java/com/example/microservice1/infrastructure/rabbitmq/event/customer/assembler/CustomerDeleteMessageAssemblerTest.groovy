package com.example.microservice1.infrastructure.rabbitmq.event.customer.assembler


import com.example.microservice1.infrastructure.rabbitmq.event.customer.dto.CustomerDeleteDto
import spock.lang.Specification 
/**
 * Created by mtumilowicz on 2018-08-01.
 */
class CustomerDeleteMessageAssemblerTest extends Specification {
    def "test toMessage - list"() {
        given:
        def customerDeleteDto = CustomerDeleteDto.builder()
                .id(_id)
                .build()

        when:
        def message = CustomerDeleteMessageAssembler.toMessage([_id])

        then:
        with(message) {
            ids == [customerDeleteDto]
        }
        
        where:
        _id << [1]
    }

    def "test toMessage - single"() {
        given:
        def customerDeleteDto = CustomerDeleteDto.builder()
                .id(_id)
                .build()

        when:
        def message = CustomerDeleteMessageAssembler.toMessage(_id)

        then:
        with(message) {
            ids == [customerDeleteDto]
        }

        where:
        _id << [1]
    }
}
