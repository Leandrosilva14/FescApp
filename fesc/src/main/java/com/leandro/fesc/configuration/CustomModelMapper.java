package com.leandro.fesc.configuration;

import org.modelmapper.ModelMapper;

public class CustomModelMapper extends ModelMapper {

    public CustomModelMapper() {
        addConverter(new LocalDateSpringConverter());
        addConverter(new LocalDateTimeSpringConverter());
    }

}
