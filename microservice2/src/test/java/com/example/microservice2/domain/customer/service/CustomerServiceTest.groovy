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
        def customer = new Customer(
                firstName: "firstName",
        )

        and:
        def customerAfterSave = new Customer(
                id: 1,
                firstName: "firstName",
        )

        and:
        def repository = Mock(CustomerRepository)

        and:
        def service = new CustomerService(repository)

        when:
        service.save(customer)

        then:
        1 * repository.save({ it == customer } as Customer) >> customerAfterSave
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
