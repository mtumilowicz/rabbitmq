package com.example.microservice2.domain.customer.service

import com.example.microservice2.domain.customer.model.Customer
import com.example.microservice2.infrastructure.repository.CustomerRepository
import spock.lang.Specification

/**
 * Created by mtumilowicz on 2018-07-20.
 */
class CustomerServiceTest extends Specification {

    def "test save"() {
        given:
        def customer = Customer.builder()
        .firstName("firstName")
        .build()

        and:
        def customerAfterSave = Customer.builder()
        .id(1)
        .firstName("firstName")
        .build()

        and:
        def repository = Mock(CustomerRepository)

        and:
        def service = new CustomerService(repository)

        when:
        service.save([customer])

        then:
        1 * repository.saveAll([customer]) >> [customerAfterSave]
    }

    def "test delete"() {
        given:
        def customers = [new Customer(1, "")]

        and:
        def repository = Mock(CustomerRepository) {
            findAllById([1]) >> customers
        }

        and:
        def service = new CustomerService(repository)

        when:
        service.delete([1])

        then:
        1 * repository.deleteAll(customers)
    }

    def "test findAll"() {
        given:
        def repository = Mock(CustomerRepository)

        and:
        def service = new CustomerService(repository)

        when:
        service.findAll()

        then:
        1 * repository.findAll()
    }
}
