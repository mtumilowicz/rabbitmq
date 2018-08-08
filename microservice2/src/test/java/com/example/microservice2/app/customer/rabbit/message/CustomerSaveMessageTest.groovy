package com.example.microservice2.app.customer.rabbit.message


import com.example.microservice2.app.customer.rabbit.message.dto.CustomerSaveDto
import spock.lang.Specification

/**
 * Created by mtumilowicz on 2018-08-02.
 */
class CustomerSaveMessageTest extends Specification {
    def "test getBody - check that list is non null"() {
        given:
        def message = new CustomerSaveMessage(null)

        expect:
        message.getBody() == []
    }

    def "test getBody - check that list is immutable"() {
        given:
        def message = new CustomerSaveMessage([])

        when:
        message.getBody().add(new CustomerSaveDto(1, ""))

        then:
        message.getBody() == []
    }
}
