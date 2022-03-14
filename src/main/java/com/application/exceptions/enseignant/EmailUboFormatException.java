package com.application.exceptions.enseignant;

import org.springframework.util.StringUtils;

public class EmailUboFormatException extends RuntimeException{
	private static String generateMessage(String entity, String email) {
		return "Format " + email + " n'est pas bonne pour " + StringUtils.capitalize(entity) + "--- Réessayer avec nomprenom@univ-brest.com !";
	}
	
	public EmailUboFormatException(Class c, String email) {
		super(EmailUboFormatException.generateMessage(c.getSimpleName(), email));
	}
	
}