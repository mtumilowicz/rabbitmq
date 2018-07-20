package com.example.microservice1.infrastructure.rabbitmq.publisher

import com.example.microservice1.infrastructure.rabbitmq.event.CustomerCreate
import spock.lang.Specification

/**
 * Created by mtumilowicz on 2018-07-20.
 */
class CustomerPublisherTest extends Specification {
    def "test publishCreate"() {
        given:
        def createPublisher = Mock(CustomerCreatePublisher)

        and:
        def customerPublisher = new CustomerPublisher(createPublisher)

        and:
        def message = CustomerCreate.builder().build()
        
        when:
        customerPublisher.publishCreate(message)
        
        then:
        createPublisher.publish(message)
    }
}
