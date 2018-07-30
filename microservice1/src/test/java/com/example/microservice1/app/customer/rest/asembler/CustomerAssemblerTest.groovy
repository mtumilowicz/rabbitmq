package com.example.microservice1.app.customer.rest.asembler

import com.example.microservice1.domain.customer.model.Customer
import com.example.microservice1.app.customer.rest.dto.CustomerDto
import spock.lang.Specification

/**
 * Created by mtumilowicz on 2018-07-20.
 */
class CustomerAssemblerTest extends Specification {
    def "test toEntity"() {
        given:
        def customerDto = CustomerDto.builder()
                .firstName("firstName")
                .build()

        def expectedCustomer = Customer.builder()
                .firstName("firstName")
                .build()

        when:
        def customer = CustomerAssembler.toEntity(customerDto)

        then:
        expectedCustomer == customer
    }
}
