package com.example.microservice2.app.customer.rabbit.assembler

import com.example.microservice2.app.customer.rabbit.dto.CustomerSaveDto
import spock.lang.Specification

/**
 * Created by mtumilowicz on 2018-08-02.
 */
class CustomerSaveDtoAssemblerTest extends Specification {
    def "test toEntity"() {
        given:
        def dto = CustomerSaveDto.builder()
                .id(_id)
                .firstName(_firstName)
                .build()

        when:
        def entity = CustomerSaveDtoAssembler.toEntity(dto)

        then:
        with(entity) {
            id == _id
            firstName == _firstName
        }

        where:
        _id | _firstName
        1   | "firstName"
    }
}
