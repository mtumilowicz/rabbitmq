package com.example.microservice1.infrastructure.rabbitmq.publisher.customer

import com.example.microservice1.domain.customer.model.Customer
import com.example.microservice1.infrastructure.rabbitmq.event.customer.CustomerCreate
import com.example.microservice1.infrastructure.rabbitmq.event.customer.CustomerDelete
import com.example.microservice1.infrastructure.rabbitmq.publisher.customer.CustomerCreatePublisher
import com.example.microservice1.infrastructure.rabbitmq.publisher.customer.CustomerDeletePublisher
import com.example.microservice1.infrastructure.rabbitmq.publisher.customer.CustomerPublisher
import spock.lang.Specification

/**
 * Created by mtumilowicz on 2018-07-20.
 */
class CustomerPublisherTest extends Specification {
    def "test publishCreate"() {
        given:
        def createPublisher = Mock(CustomerCreatePublisher)

        and:
        def customerPublisher = new CustomerPublisher(createPublisher, Mock(CustomerDeletePublisher))

        and:
        def customer = Customer.builder()
                .id(1)
                .firstName("firstName")
                .build()

        and:
        def message = CustomerCreate.builder()
                .id(1)
                .firstName("firstName")
                .build()

        when:
        customerPublisher.publishCreate(customer)

        then:
        1 * createPublisher.publish(message)
    }

    def "test publishDelete"() {
        given:
        def deletePublisher = Mock(CustomerDeletePublisher)

        and:
        def customerPublisher = new CustomerPublisher(Mock(CustomerCreatePublisher), deletePublisher)

        and:
        def id = 1

        when:
        customerPublisher.publishDelete(id)

        then:
        1 * deletePublisher.publish({it.id == id} as CustomerDelete)
    }
}
