package com.example.microservice1.app.customer.rabbit.message.assembler


import spock.lang.Specification 
/**
 * Created by mtumilowicz on 2018-08-01.
 */
class CustomerDeleteDtoAssemblerTest extends Specification {
    def "test toDto"() {
        when:
        def dto = CustomerDeleteDtoAssembler.toDto(_id)

        then:
        with(dto) {
            id == _id
        }
        
        where:
        _id << [1]
    }
}
