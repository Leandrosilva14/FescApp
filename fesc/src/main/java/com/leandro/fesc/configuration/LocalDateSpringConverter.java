package com.leandro.fesc.configuration;

import org.modelmapper.AbstractConverter;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class LocalDateSpringConverter extends AbstractConverter<LocalDate, String> {

    @Override
    protected String convert(LocalDate localDate) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/uuuu");
        return localDate.format(formatter);
    }
}
