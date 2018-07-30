package com.example.microservice2.app.rest.customer

import com.example.microservice2.domain.customer.service.CustomerService
import spock.lang.Specification

/**
 * Created by mtumilowicz on 2018-07-20.
 */
class CustomerControllerTest extends Specification {

    def service = Mock(CustomerService)
    def controller = new CustomerController(service)
    
    def "test findAll"() {
        when:
        controller.findAll()

        then:
        1 * service.findAll()
    }
}
