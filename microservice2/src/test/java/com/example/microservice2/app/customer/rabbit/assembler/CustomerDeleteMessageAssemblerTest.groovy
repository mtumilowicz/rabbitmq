package com.example.microservice2.app.customer.rabbit.assembler

import com.example.microservice2.app.customer.rabbit.dto.CustomerDeleteDto
import com.example.microservice2.app.customer.rabbit.message.CustomerDeleteMessage
import spock.lang.Specification

/**
 * Created by mtumilowicz on 2018-08-02.
 */
class CustomerDeleteMessageAssemblerTest extends Specification {
    def "test extractIds"() {
        given:
        def dto = CustomerDeleteDto.builder()
                .id(_id)
                .build()

        and:
        def message = CustomerDeleteMessage.builder()
                .body([dto])
                .build()

        when:
        def body = CustomerDeleteMessageAssembler.extractIds(message)

        then:
        body == [_id]
        
        where:
        _id << [1]
    }
}
