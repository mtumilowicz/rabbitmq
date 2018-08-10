package com.example.microservice2.infrastructure.mapper;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.config.Configuration;

/**
 * Created by mtumilowicz on 2018-08-03.
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class ModelMapperFactory {
    public static ModelMapper directFieldMapper() {
        ModelMapper mapper = new ModelMapper();

        mapper.getConfiguration()
                .setFieldAccessLevel(Configuration.AccessLevel.PRIVATE)
                .setFieldMatchingEnabled(true);

        return mapper;
    }
}
