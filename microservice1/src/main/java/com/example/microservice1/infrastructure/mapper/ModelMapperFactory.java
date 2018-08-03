package com.example.microservice1.infrastructure.mapper;

import org.modelmapper.ModelMapper;
import org.modelmapper.config.Configuration;

/**
 * Created by mtumilowicz on 2018-08-03.
 */
public class ModelMapperFactory {
    public static ModelMapper directFieldMapper() {
        ModelMapper mapper = new ModelMapper();

        mapper.getConfiguration()
                .setFieldAccessLevel(Configuration.AccessLevel.PRIVATE)
                .setFieldMatchingEnabled(true);

        return mapper;
    }

    private ModelMapperFactory() {
    }
}
