package com.nagarro.techassignment.converter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;



@Converter
public class DateAttributeConverter implements AttributeConverter<LocalDate, String> {

    private final String DATE_FORMAT = "dd.MM.yyyy";

    @Override
    public String convertToDatabaseColumn(LocalDate date) {
    	String stringDate = date.format(DateTimeFormatter.ofPattern(DATE_FORMAT));
        return stringDate;
    }

    @Override
    public LocalDate convertToEntityAttribute(String dateString) {
        LocalDate converted = null;
        try {
        	DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_FORMAT);
        	converted = LocalDate.parse(dateString, formatter);
        } catch (DateTimeParseException ex) {
        	
        }
        return converted;
    }
}