package com.leandro.fesc.configuration;

import org.modelmapper.AbstractConverter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LocalDateTimeSpringConverter extends AbstractConverter<LocalDateTime, String> {

    @Override
    protected String convert(LocalDateTime localDate) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/uuuu kk:mm:ss");
        return localDate.format(formatter);
    }
}
