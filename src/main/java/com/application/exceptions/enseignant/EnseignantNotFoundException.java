package com.application.exceptions.enseignant;

import org.springframework.util.StringUtils;

public class EnseignantNotFoundException extends RuntimeException {

	private static String generateMessage(String entity, Long id) {
		return "Aucun "+  StringUtils.capitalize(entity) + " n'existe pour l'identifiant : " + id + '.';
	}
	
	public EnseignantNotFoundException(Class c, Long id) {
		super(EnseignantNotFoundException.generateMessage(c.getSimpleName(), id));
	}

}
