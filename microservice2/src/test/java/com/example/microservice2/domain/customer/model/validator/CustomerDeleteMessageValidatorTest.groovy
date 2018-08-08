package com.example.microservice2.domain.customer.model.validator

import com.example.microservice2.app.customer.rabbit.message.dto.CustomerDeleteDto
import com.example.microservice2.app.customer.rabbit.message.CustomerDeleteMessage
import spock.lang.Specification

/**
 * Created by mtumilowicz on 2018-08-02.
 */
class CustomerDeleteMessageValidatorTest extends Specification {
    def "test validate - body non null"() {
        when:
        CustomerDeleteMessageValidator.validate(new CustomerDeleteMessage())

        then:
        noExceptionThrown()
    }

    def "test validate - null dtos"() {
        when:
        CustomerDeleteMessageValidator.validate(new CustomerDeleteMessage([null]))

        then:
        thrown(IllegalStateException)
    }


    def "test validate - dtos with non null ids"() {
        when:
        CustomerDeleteMessageValidator.validate(new CustomerDeleteMessage([new CustomerDeleteDto(null)]))

        then:
        thrown(IllegalStateException)
    }
}
