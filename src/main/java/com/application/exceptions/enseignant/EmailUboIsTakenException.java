package com.application.exceptions.enseignant;

import org.springframework.util.StringUtils;

public class EmailUboIsTakenException extends RuntimeException {
	
	private static String generateMessage(String entity, String email) {
		return "L'adresse mail UBO renseignée : " + email + " est déjà utilisée par un autre " + StringUtils.capitalize(entity) +'.';
	}
	
	public EmailUboIsTakenException(Class c, String email) {
		super(EmailUboIsTakenException.generateMessage(c.getSimpleName(), email));
	}
	
}
