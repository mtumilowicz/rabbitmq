package com.example.microservice2.app.customer.rabbit.message

import com.example.microservice2.app.customer.rabbit.dto.CustomerDeleteDto
import spock.lang.Specification

/**
 * Created by mtumilowicz on 2018-08-02.
 */
class CustomerDeleteMessageTest extends Specification {
    def "test getBody - check that list is non null"() {
        given:
        def message = new CustomerDeleteMessage(null)

        expect:
        message.getBody() == []
    }

    def "test getBody - check that list is immutable"() {
        given:
        def message = new CustomerDeleteMessage([])
        
        when:
        message.getBody().add(new CustomerDeleteDto(1))

        then:
        message.getBody() == []
    }
}
