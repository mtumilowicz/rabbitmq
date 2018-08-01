package com.example.microservice1.infrastructure.rabbitmq.publisher.customer


import com.example.microservice1.infrastructure.rabbitmq.event.customer.CustomerDeleteMessage
import com.example.microservice1.infrastructure.rabbitmq.event.customer.CustomerSaveMessage
import com.example.microservice1.infrastructure.rabbitmq.event.customer.dto.CustomerDeleteDto
import com.example.microservice1.infrastructure.rabbitmq.event.customer.dto.CustomerSaveDto
import spock.lang.Specification

/**
 * Created by mtumilowicz on 2018-07-20.
 */
class CustomerMessagePublisherTest extends Specification {
    def "test publishSave"() {
        given:
        def createPublisher = Mock(CustomerSavePublisher)

        and:
        def customerPublisher = new CustomerMessagePublisher(createPublisher, Mock(CustomerDeletePublisher))

        and:
        def customerSaveDto = CustomerSaveDto.builder()
                .id(1)
                .firstName("firstName")
                .build()

        and:
        def message = CustomerSaveMessage.builder()
                .customerSaves([customerSaveDto])
                .build()

        when:
        customerPublisher.publishSave(message)

        then:
        1 * createPublisher.publish(message)
    }

    def "test publishDelete"() {
        given:
        def deletePublisher = Mock(CustomerDeletePublisher)

        and:
        def customerPublisher = new CustomerMessagePublisher(Mock(CustomerSavePublisher), deletePublisher)

        and:
        def customerDeleteDto = CustomerDeleteDto.builder()
                .id(1)
                .build()

        and:
        def message = CustomerDeleteMessage.builder()
                .ids([customerDeleteDto])
                .build()

        when:
        customerPublisher.publishDelete(message)

        then:
        1 * deletePublisher.publish(message)
    }
}
