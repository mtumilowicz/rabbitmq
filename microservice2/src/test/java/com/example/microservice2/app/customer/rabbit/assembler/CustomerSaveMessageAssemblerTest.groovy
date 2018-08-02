package com.example.microservice2.app.customer.rabbit.assembler

import com.example.microservice2.app.customer.rabbit.dto.CustomerSaveDto
import com.example.microservice2.app.customer.rabbit.message.CustomerSaveMessage
import com.example.microservice2.domain.customer.model.Customer
import spock.lang.Specification

/**
 * Created by mtumilowicz on 2018-08-02.
 */
class CustomerSaveMessageAssemblerTest extends Specification {
    def "test toEntities"() {
        given:
        def expectedCustomer = Customer.builder()
                .id(_id)
                .firstName(_firstName)
                .build()
        
        and:
        def dto = CustomerSaveDto.builder()
                .id(_id)
                .firstName(_firstName)
                .build()

        and:
        def message = CustomerSaveMessage.builder()
                .customerSaves([dto])
                .build()

        when:
        def entities = CustomerSaveMessageAssembler.toEntities(message)

        then:
        entities == [expectedCustomer]

        where:
        _id | _firstName
        1   | "firstName"
    }
}
