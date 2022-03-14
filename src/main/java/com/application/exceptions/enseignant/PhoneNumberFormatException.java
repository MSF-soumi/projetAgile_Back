package com.application.exceptions.enseignant;

import org.springframework.util.StringUtils;

public class PhoneNumberFormatException  extends RuntimeException{
	private static String generateMessage(String entity, String phoneNumber) {
		return "Format " + phoneNumber + " n'est pas bonne pour " + StringUtils.capitalize(entity);
	}
	
	public PhoneNumberFormatException(Class c, String phoneNumber) {
		super(PhoneNumberFormatException.generateMessage(c.getSimpleName(), phoneNumber));
	}
}