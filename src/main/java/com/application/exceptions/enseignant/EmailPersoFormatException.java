package com.application.exceptions.enseignant;

import org.springframework.util.StringUtils;

public class EmailPersoFormatException extends RuntimeException{
	
	private static String generateMessage(String entity, String email) {
		return "Format " + email + " n'est pas bonne pour " + StringUtils.capitalize(entity);
	}
	public EmailPersoFormatException(Class c, String email) {
		super(EmailPersoFormatException.generateMessage(c.getSimpleName(), email));
	}
}