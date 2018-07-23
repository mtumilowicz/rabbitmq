package com.example.microservice1.rest.customer

import com.example.microservice1.domain.customer.model.Customer
import com.example.microservice1.domain.customer.service.CustomerService
import com.example.microservice1.rest.customer.dto.CustomerDto
import spock.lang.Specification

/**
 * Created by mtumilowicz on 2018-07-20.
 */
class CustomerControllerTest extends Specification {

    def service = Mock(CustomerService)
    def controller = new CustomerController(service)

    def "test save"() {
        given:
        def dto = CustomerDto.builder()
                .firstName("firstName")
                .build()

        and:
        def expectedCustomer = Customer.builder()
                .firstName("firstName")
                .build()

        when:
        controller.save(dto)

        then:
        1 * service.save({ it == expectedCustomer } as Customer)
    }

    def "test delete"() {
        when:
        controller.deleteById(1)

        then:
        1 * service.deleteById(1)
    }

    def "test findAll"() {
        when:
        controller.findAll()

        then:
        1 * service.findAll()
    }

    def "test deleteById"() {
        when:
        controller.deleteById(1)

        then:
        1 * service.deleteById(1)
    }
}
