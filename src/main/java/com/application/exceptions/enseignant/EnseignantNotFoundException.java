package com.application.exceptions.enseignant;

import org.springframework.util.StringUtils;

public class EnseignantNotFoundException extends RuntimeException {
private static String generateMessage(String entity, Long id) {
		
		return "l'id: " + id + " n'existe pas ! --" + StringUtils.capitalize(entity);
	}
	
	public EnseignantNotFoundException(Class c, Long id) {
		super(EnseignantNotFoundException.generateMessage(c.getSimpleName(), id));
	}
}