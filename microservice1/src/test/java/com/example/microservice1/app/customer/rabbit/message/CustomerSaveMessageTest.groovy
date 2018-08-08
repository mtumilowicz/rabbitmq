package com.example.microservice1.app.customer.rabbit.message

import com.example.microservice1.app.customer.rabbit.message.CustomerSaveMessage
import com.example.microservice1.app.customer.rabbit.message.dto.CustomerSaveDto
import spock.lang.Specification

/**
 * Created by mtumilowicz on 2018-08-02.
 */
class CustomerSaveMessageTest extends Specification {
    def "constructor - null list"() {
        when:
        def message = new CustomerSaveMessage(null)

        then:
        message.body == []
    }

    def "constructor - list with null elem"() {
        when:
        new CustomerSaveMessage([null])

        then:
        thrown(NullPointerException)
    }

    def "body - check immutability"() {
        when:
        new CustomerSaveMessage([]).body.add(new CustomerSaveDto(1, ""))

        then:
        thrown(UnsupportedOperationException)
    }
}
