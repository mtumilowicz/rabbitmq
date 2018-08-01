package com.example.microservice1.domain.customer.service

import com.example.microservice1.domain.customer.model.Customer
import com.example.microservice1.infrastructure.rabbitmq.publisher.customer.CustomerMessagePublisher
import com.example.microservice1.infrastructure.repository.CustomerRepository
import spock.lang.Specification
/**
 * Created by mtumilowicz on 2018-07-20.
 */
class CustomerServiceTest extends Specification {
    def "test save - repository"() {
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
        def service = new CustomerService(repository, Mock(CustomerMessagePublisher))

        when:
        service.save(customer)

        then:
        1 * repository.save({ it == customer } as Customer) >> customerAfterSave
    }

    def "test save - check if message was publisher"() {
        given:
        def customer = new Customer(
                firstName: "firstName",
        )

        and:
        def customerAfterSave = new Customer(
                id: 1,
                firstName: "firstName",
        )
        
        def repository = Mock(CustomerRepository) {
            save(_) >> customerAfterSave
        }

        and:
        def publisher = Mock(CustomerMessagePublisher)

        and:
        def service = new CustomerService(repository, publisher)

        when:
        service.save(customer)

        then:
        1 * publisher.publishSave(_)
    }

    def "test findAll"() {
        given:
        def repository = Mock(CustomerRepository)

        and:
        def service = new CustomerService(repository, Mock(CustomerMessagePublisher))

        when:
        service.findAll()

        then:
        1 * repository.findAll()
    }

    def "test delete"() {
        given:
        def repository = Mock(CustomerRepository)

        and:
        def service = new CustomerService(repository, Mock(CustomerMessagePublisher))

        when:
        service.deleteById(1)

        then:
        1 * repository.deleteById(1)
    }

    def "test delete - check if message was publisher"() {
        given:
        def repository = Mock(CustomerRepository)

        and:
        def publisher = Mock(CustomerMessagePublisher)

        and:
        def service = new CustomerService(repository, publisher)

        when:
        service.deleteById(1)

        then:
        1 * repository.deleteById(1)
    }
}
