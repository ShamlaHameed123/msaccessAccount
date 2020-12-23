package com.nagarro.techassignment.converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;



@Converter
public class DateAttributeConverter implements AttributeConverter<Date, String> {

    private final String DATE_FORMAT = "DD.MM.YYYY";

    @Override
    public String convertToDatabaseColumn(Date date) {
        return new SimpleDateFormat(DATE_FORMAT).format(date);
    }

    @Override
    public Date convertToEntityAttribute(String dateString) {
        Date converted = null;
        try {
            converted = new SimpleDateFormat(DATE_FORMAT).parse(dateString);
        } catch (ParseException ex) {
        	
        }
        return converted;
    }
}