
package com.nagarro.techassignment.converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;



@Converter
public class AmountStringAttributeConverter implements AttributeConverter<Double, String> {

	@Override
	public String convertToDatabaseColumn(Double attribute) {
	
		return Double.toString(attribute);
	}

	@Override
	public Double convertToEntityAttribute(String dbData) {
		return Double.parseDouble(dbData);
	}
}