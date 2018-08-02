package com.example.microservice2.domain.customer.model.validator

import com.example.microservice2.app.customer.rabbit.dto.CustomerSaveDto
import com.example.microservice2.app.customer.rabbit.message.CustomerSaveMessage
import spock.lang.Specification 
/**
 * Created by mtumilowicz on 2018-08-02.
 */
class CustomerSaveMessageValidatorTest extends Specification {
    def "test validate - body non null"() {
        when:
        CustomerSaveMessageValidator.validate(new CustomerSaveMessage())
        
        then:
        noExceptionThrown()
    }

    def "test validate - null dtos"() {
        when:
        CustomerSaveMessageValidator.validate(new CustomerSaveMessage([null]))

        then:
        thrown(IllegalStateException)
    }

    def "test validate - dtos with non null ids"() {
        when:
        CustomerSaveMessageValidator.validate(new CustomerSaveMessage([new CustomerSaveDto(null, "")]))

        then:
        thrown(IllegalStateException)
    }
}
