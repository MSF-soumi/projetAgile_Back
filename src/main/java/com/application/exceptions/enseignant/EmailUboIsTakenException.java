package com.application.exceptions.enseignant;

import org.springframework.util.StringUtils;

public class EmailUboIsTakenException extends RuntimeException {
	
	private static String generateMessage(String entity, String email) {
		return "\n L'adresse mail UBO : " + email + " est déjà utilisée.";
	}
	
	public EmailUboIsTakenException(Class c, String email) {
		super(EmailUboIsTakenException.generateMessage(c.getSimpleName(), email));
	}
	
}
