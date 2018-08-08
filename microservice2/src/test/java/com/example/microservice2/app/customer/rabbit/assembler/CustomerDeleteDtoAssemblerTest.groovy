package com.example.microservice2.app.customer.rabbit.assembler

import com.example.microservice2.app.customer.rabbit.message.dto.CustomerDeleteDto
import spock.lang.Specification

/**
 * Created by mtumilowicz on 2018-08-02.
 */
class CustomerDeleteDtoAssemblerTest extends Specification {
    def "test extractId"() {
        given:
        def dto = CustomerDeleteDto.builder()
                .id(_id)
                .build()

        expect:
        _id == CustomerDeleteDtoAssembler.extractId(dto)
        
        where:
        _id << [1]
    }
}
