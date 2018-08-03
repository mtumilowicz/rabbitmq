package com.example.microservice2.infrastructure.mapper

import org.modelmapper.config.Configuration
import spock.lang.Specification

/**
 * Created by mtumilowicz on 2018-08-03.
 */
class ModelMapperFactoryTest extends Specification {
    def "test directFieldMapper"() {
        given:
        def configuration = ModelMapperFactory.directFieldMapper().getConfiguration()

        expect:
        configuration.fieldAccessLevel == Configuration.AccessLevel.PRIVATE
        configuration.fieldMatchingEnabled
    }
}
